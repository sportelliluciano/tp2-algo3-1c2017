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
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.error.ErrorYaAtaco;
import model.error.ErrorYaMovio;

public class ContenedorHUD extends BorderPane {

	private HBox botoneraAcciones, botoneraPersonajes;
	private VBox statsPersonaje;
	private Button btnPasarTurno, btnAccion, btnTransformarse;
	private Button btnPersonajes[];
	private Juego juego;
	private Jugador jugador;
	private Label ki;
	private Label vida;
	private Label nombreUnidad;
	private Unidad personajeSeleccionado;
	private ContenedorTablero contenedorTablero;
	private double altoHUD;
	
	public ContenedorHUD(Juego juego, ContenedorTablero contenedorTablero, double alto) {
		this.juego = juego;
		this.jugador = juego.getJugadorActual();
		altoHUD = alto;
		nombreUnidad = new Label();
		vida = new Label();
		ki = new Label();
		botoneraAcciones = new HBox();
		botoneraPersonajes = new HBox();
		statsPersonaje = new VBox();
		
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
		botoneraAcciones.getChildren().addAll(btnPasarTurno,btnAccion,btnTransformarse);
		botoneraAcciones.setPadding(new Insets(10, 0, 0, 0));
		
		statsPersonaje.getChildren().addAll(nombreUnidad, vida, ki);
		
		vida.setStyle("-fx-text-fill: white;");
		ki.setStyle("-fx-text-fill: white;");
		nombreUnidad.setStyle("-fx-text-fill: white;");
		
		setMinHeight(alto);
		setMaxHeight(alto);
		this.setRight(botoneraAcciones);
		this.setLeft(botoneraPersonajes);
		//this.setCenter(statsPersonaje);
		deseleccionarPersonaje();
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
		jugador = juego.siguienteTurno();
		deseleccionarPersonaje();
		contenedorTablero.desmarcarTodasLasPosiciones();
		cambioEquipo();
		actualizar();
	}
	
	public void clicAccion() {
		Posicionable p = contenedorTablero.getPosicionableSeleccionado();
		Posicion pos = contenedorTablero.getPosicionSeleccionada();
		
		if ((p == null) || (p instanceof Consumible)) {
			try {
				jugador.mover(personajeSeleccionado, pos);
				actualizar();
			} catch (ErrorPosicionInvalida e) {
				nombreUnidad.setText("Demasiado lejos");
				
			} catch (ErrorUnidadParalizada e) {
				nombreUnidad.setText("¡La unidad está paralizada!");
			}
			catch (ErrorYaMovio e) {
				nombreUnidad.setText("Ya movió un personaje");
			}
		}
		else if(p instanceof Unidad) {
			try {
				jugador.ataqueBasico(personajeSeleccionado, (Unidad)p);
				actualizar();
			} catch (ErrorUnidadParalizada | ErrorUnidadNoEsEnemiga | ErrorEnemigoFueraDeAlcance
					| ErrorPosicionInvalida | ErrorYaAtaco e) {
				nombreUnidad.setText("Nope");
			}
		}
		contenedorTablero.desmarcarTodasLasPosiciones();
		actualizar();
	}
	
	public void clicTransformarse() {
		try {
			personajeSeleccionado.transformarse();
			actualizar();
		} catch (ErrorNoCumpleReqTrans e) {
			nombreUnidad.setText("¡No se puede transformar en este momento!");
		}
		catch (ErrorNoHayMasTrans e) {
			nombreUnidad.setText("El personaje está en su última transformación");
		}
	}

	public void posicionSeleccionada(Posicion p) {
		if (personajeSeleccionado == null)
			return;
		btnAccion.setGraphic(new ImageView(FabricaSprites.getSpriteBoton("mover")));
	}

	public void personajeSeleccionado(Unidad p) {
		nombreUnidad.setText("Seleccionado: " + p.getNombre());
		vida.setText("Vida: "+p.getVida().getVidaActual()+"/"+p.getVida().getVidaMaxima());
		ki.setText("Ki: "+p.getKi().getMagnitud() );
		btnAccion.setDisable(false);
		btnTransformarse.setDisable(false);
		
		if (jugador.equipo().pertenece(p))
			personajePropioSeleccionado(p);
		else
			personajeEnemigoSeleccionado(p);
		
		actualizar();
	}
	
	private void personajeEnemigoSeleccionado(Unidad p) {
		contenedorTablero.desmarcarTodasLasPosiciones();
		btnAccion.setGraphic(new ImageView(FabricaSprites.getSpriteBoton("atacar")));
	}

	private void personajePropioSeleccionado(Unidad p) {
		personajeSeleccionado = p;
		try {
			Set<Posicion> posiciones = juego.getTablero().getMovimientosPosibles(p.getPosicion(), p.getVelocidad());
			contenedorTablero.marcarPosiciones(posiciones);
		}
		catch (ErrorUnidadParalizada ex) {
			return;
		}
	}
}

