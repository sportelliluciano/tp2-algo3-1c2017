package view;

import java.util.Set;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Consumible;
import model.Juego;
import model.Jugador;
import model.Posicion;
import model.Posicionable;
import model.Unidad;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.error.ErrorYaAtaco;
import model.error.ErrorYaMovio;

public class ContenedorHUD extends BorderPane {

	private HBox botoneraAcciones, botoneraPersonajes;
	private ContenedorStats statsPersonaje;
	private Button btnPasarTurno, btnAccion, btnTransformarse, btnAtaqueEspecial;
	private Button btnPersonajes[];
	private Juego juego;
	private Jugador jugador;
	private Label mensajeEstado;
	private Unidad personajeSeleccionado;
	private ContenedorTablero contenedorTablero;
	private double altoHUD;
	
	public ContenedorHUD(Juego juego, ContenedorTablero contenedorTablero, double alto) {
		this.juego = juego;
		this.jugador = juego.getJugadorActual();
		altoHUD = alto;
		botoneraAcciones = new HBox();
		botoneraPersonajes = new HBox();
		mensajeEstado = new Label();
		mensajeEstado.setStyle("-fx-text-fill: white;");
		this.getStyleClass().add("hud");
		
		cambioEquipo();
		
		this.contenedorTablero = contenedorTablero;
		
		btnPersonajes = new Button[3];
		
		for(int i=0;i<3;i++) {
			Unidad personaje = jugador.getPersonajes().get(i);
			btnPersonajes[i] = new Button(personaje.getNombre());
			btnPersonajes[i].setUserData(i);
			btnPersonajes[i].setOnAction(e -> seleccionarPersonaje(e));
			ImageView imagen = new ImageView(FabricaSprites.getSpritePosicionable(personaje));
			imagen.setPreserveRatio(true);
			imagen.setFitHeight(alto * 0.5);
			btnPersonajes[i].setGraphic(imagen);
			botoneraPersonajes.getChildren().add(btnPersonajes[i]);
		}
		botoneraPersonajes.setSpacing(10);
		botoneraPersonajes.setPadding(new Insets(10));
		
		btnPasarTurno = new Button();
		btnPasarTurno.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_pasar_turno.png"));
		btnPasarTurno.setOnAction(e -> clicPasarTurno() );
		btnTransformarse = new Button();
		btnTransformarse.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_transformacion.png"));
		btnTransformarse.setOnAction(e -> clicTransformarse() );
		btnAccion = new Button();
		btnAccion.setOnAction(e -> clicAccion() );
		btnAccion.setDisable(true);
		btnAccion.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_atacar_mover.png"));
		btnAtaqueEspecial = new Button();
		btnAtaqueEspecial.setOnAction(e -> clicAtaqueEspecial() );
		btnAtaqueEspecial.setDisable(true);
		btnAtaqueEspecial.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_atacar_especial.png"));
		botoneraAcciones.getChildren().addAll(btnPasarTurno, btnAccion, btnAtaqueEspecial, btnTransformarse);
		botoneraAcciones.setPadding(new Insets(10, 0, 0, 0));
		
		setMinHeight(alto);
		setMaxHeight(alto);
		this.setRight(botoneraAcciones);
		this.setLeft(botoneraPersonajes);
		this.setCenter(mensajeEstado);
		deseleccionarPersonaje();
	}
	
	public void clicAtaqueEspecial() {
		if (btnAtaqueEspecial.isDisabled())
			return;
		Posicionable enemigo = contenedorTablero.getPosicionableSeleccionado();
		
		try {
			if (!(enemigo instanceof Unidad))
				return;
			jugador.ataqueEspecial(personajeSeleccionado, (Unidad)enemigo);
		} 
		catch (ErrorUnidadParalizada e) {
			mensajeEstado.setText("¡La unidad está paralizada!");
		} catch (ErrorPosicionInvalida e) {
			mensajeEstado.setText("Demasiado lejos");
		}  catch (ErrorKiInsuficiente e) {
			mensajeEstado.setText("Ki insuficiente");
		} catch (ErrorUnidadNoEsEnemiga e) {
			mensajeEstado.setText("No se permite el fuego amigo");
		} catch (ErrorYaAtaco e) {
			mensajeEstado.setText("Ya atacó en este turno.");
		} catch (ErrorEnemigoFueraDeAlcance e) {
			mensajeEstado.setText("El enemigo está muy lejos");
		}
		
		contenedorTablero.desmarcarTodasLasPosiciones();
		btnAccion.setDisable(true);
		btnAtaqueEspecial.setDisable(true);
		actualizar();
	}

	public void seleccionarPersonaje(ActionEvent e) {
		personajeSeleccionado(jugador.getPersonajes().get((int) ((Button)e.getSource()).getUserData()));
		setLeft(statsPersonaje);
	}
	
	public void deseleccionarPersonaje() {
		personajeSeleccionado = null;
		btnAccion.setDisable(true);
		btnTransformarse.setDisable(true);
		setLeft(botoneraPersonajes);
	}
	
	private void actualizar() {
		for(int i=0;i<3;i++) {
			Unidad personaje = jugador.getPersonajes().get(i);
			btnPersonajes[i].setText(personaje.getNombre());
			ImageView imagen = new ImageView(FabricaSprites.getSpritePosicionable(personaje));
			imagen.setPreserveRatio(true);
			imagen.setFitHeight(altoHUD * 0.5);
			btnPersonajes[i].setGraphic(imagen);
		}
		contenedorTablero.actualizar();
		if (statsPersonaje != null)
			statsPersonaje.actualizar();
	}

	private void cambioEquipo() {
		if (jugador.equipo() instanceof GuerrerosZ) {
			this.getStyleClass().remove("enemigos");
			this.getStyleClass().add("guerreros");
		}
		else {
			this.getStyleClass().remove("guerreros");
			this.getStyleClass().add("enemigos");
		}
	}
	
	public void clicPasarTurno() {
		mensajeEstado.setText("");
		jugador = juego.siguienteTurno();
		deseleccionarPersonaje();
		contenedorTablero.desmarcarTodasLasPosiciones();
		cambioEquipo();
		actualizar();
	}
	
	public void clicAccion() {
		if (btnAccion.isDisabled())
			return;
		Posicionable p = contenedorTablero.getPosicionableSeleccionado();
		Posicion pos = contenedorTablero.getPosicionSeleccionada();
		mensajeEstado.setText("");
		try {
			if ((p == null) || (p instanceof Consumible))
				jugador.mover(personajeSeleccionado, pos);
			else if (p instanceof Unidad)
				jugador.ataqueBasico(personajeSeleccionado, (Unidad)p);
		}
		catch (ErrorUnidadParalizada e) {
			mensajeEstado.setText("¡La unidad está paralizada!");
		} catch (ErrorPosicionInvalida e) {
			mensajeEstado.setText("Demasiado lejos");
		}  catch (ErrorYaMovio e) {
			mensajeEstado.setText("Ya movió un personaje");
		} catch (ErrorUnidadNoEsEnemiga e) {
			mensajeEstado.setText("No se permite el fuego amigo");
		} catch (ErrorYaAtaco e) {
			mensajeEstado.setText("Ya atacó en este turno.");
		} catch (ErrorEnemigoFueraDeAlcance e) {
			mensajeEstado.setText("El enemigo está muy lejos");
		}
		
		contenedorTablero.desmarcarTodasLasPosiciones();
		btnAccion.setDisable(true);
		btnAtaqueEspecial.setDisable(true);
		actualizar();
	}
	
	public void clicTransformarse() {
		if (btnTransformarse.isDisabled())
			return;
		try {
			personajeSeleccionado.transformarse();
			actualizar();
		} catch (ErrorNoCumpleReqTrans e) {
			mensajeEstado.setText("¡No se puede transformar en este momento!");
		}
		catch (ErrorNoHayMasTrans e) {
			mensajeEstado.setText("El personaje está en su última transformación");
		}
	}

	public void posicionSeleccionada(Posicion p) {
		if (personajeSeleccionado == null)
			return;
		btnAccion.setDisable(jugador.puedeMoverA(p, personajeSeleccionado) == false);
		btnAccion.setGraphic(new ImageView(FabricaSprites.getSpriteBoton("mover")));
	}

	public void personajeSeleccionado(Unidad p) {
		if (jugador.equipo().pertenece(p))
			personajePropioSeleccionado(p);
		else
			personajeEnemigoSeleccionado(p);
		
		actualizar();
	}
	
	private void personajeEnemigoSeleccionado(Unidad p) {
		if (personajeSeleccionado == null)
			return;
		boolean puedeAtacar = jugador.puedeAtacarA(personajeSeleccionado, p); 
		btnAccion.setDisable(puedeAtacar == false);
		btnAtaqueEspecial.setDisable(puedeAtacar == false);
		btnAccion.setGraphic(new ImageView(FabricaSprites.getSpriteBoton("atacar")));
	}

	private void personajePropioSeleccionado(Unidad p) {
		personajeSeleccionado = p;
		statsPersonaje = new ContenedorStats(p, altoHUD);
		setLeft(statsPersonaje);
		if (personajeSeleccionado.estaParalizado()) {
			mensajeEstado.setText("Esta unidad está paralizada");
			return;
		}
		else {
			mensajeEstado.setText("");
		}
			
		btnTransformarse.setDisable(false);
		try {
			Set<Posicion> posiciones = juego.getTablero().getMovimientosPosibles(p.getPosicion(), p.getVelocidad());
			contenedorTablero.marcarPosiciones(posiciones);
		}
		catch (ErrorUnidadParalizada ex) {
			return;
		}
	}
}

