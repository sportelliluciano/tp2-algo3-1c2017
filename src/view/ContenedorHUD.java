package view;

import java.util.Set;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Consumible;
import model.Juego;
import model.Jugador;
import model.Posicion;
import model.Posicionable;
import model.Unidad;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.error.ErrorYaAtaco;
import model.error.ErrorYaMovio;

public class ContenedorHUD extends BorderPane {

	private HBox botoneraAcciones;
	private Pane HUD;
	private VBox botoneraPersonajes, statsPersonaje;
	private Button btnPasarTurno, btnAccion, btnTransformarse, btnAtaqueEspecial;
	private Button btnPersonajes[];
	private Juego juego;
	private Jugador jugador;
	private Label ki;
	private Label vida;
	private Label nombreUnidad;
	private Unidad personajeSeleccionado;
	private ContenedorTablero contenedorTablero;
	private int POS_STATS_PERSONAJE = 250;
	private int POS_BOTONERA_ACCIONES = 500;
	private String PATH_IMG_BTN = "src/view/imagenes/botones/";
	
	public ContenedorHUD(Juego juego, ContenedorTablero contenedorTablero) {
		this.juego = juego;
		this.jugador = juego.getJugadorActual();
		nombreUnidad = new Label();
		vida = new Label();
		ki = new Label();
		HUD = new Pane();
		botoneraAcciones = new HBox();
		botoneraPersonajes = new VBox();
		statsPersonaje = new VBox();
		
		this.contenedorTablero = contenedorTablero;
		
		btnPersonajes = new Button[3];
		
		for(int i=0;i<3;i++) {
			btnPersonajes[i] = new Button(jugador.getPersonajes().get(i).getNombre());
			btnPersonajes[i].setUserData(i);
			btnPersonajes[i].setOnAction(e -> seleccionarPersonaje(e));
			botoneraPersonajes.getChildren().add(btnPersonajes[i]);
		}
		
		btnPasarTurno = new Button();
		btnPasarTurno.setGraphic(new ImageView("file:"+ PATH_IMG_BTN + "imagen_boton_pasar_turno.png"));
		btnPasarTurno.setOnAction(e -> clicPasarTurno() );
		btnPasarTurno.setStyle("-fx-background-color: transparent;");
		btnTransformarse = new Button();
		btnTransformarse.setGraphic(new ImageView("file:" + PATH_IMG_BTN + "imagen_boton_transformacion.png"));
		btnTransformarse.setOnAction(e -> clicTransformarse() );
		btnTransformarse.setStyle("-fx-background-color: transparent;");
		btnAccion = new Button();
		btnAccion.setOnAction(e -> clicAccion() );
		btnAccion.setDisable(true);
		btnAccion.setGraphic(new ImageView("file:" + PATH_IMG_BTN + "imagen_boton_atacar_mover.png"));
		btnAccion.setStyle("-fx-background-color: transparent;");
		btnAtaqueEspecial = new Button();
		btnAtaqueEspecial.setOnAction(e -> clicAtaqueEspecial() );
		btnAtaqueEspecial.setGraphic(new ImageView("file:"+ PATH_IMG_BTN+ "imagen_boton_ataque_especial.png"));
		btnAtaqueEspecial.setDisable(true);
		btnAtaqueEspecial.setStyle("-fx-background-color: transparent;");
		
		botoneraAcciones.getChildren().addAll(btnPasarTurno,btnAccion,btnTransformarse,btnAtaqueEspecial);
		
		statsPersonaje.getChildren().addAll(nombreUnidad,vida, ki);
		
		HUD.getChildren().addAll(statsPersonaje, botoneraAcciones, botoneraPersonajes);
		statsPersonaje.setLayoutX(POS_STATS_PERSONAJE);
		botoneraAcciones.setLayoutX(POS_BOTONERA_ACCIONES);
		this.setCenter(HUD);
	}
	
	public void seleccionarPersonaje(ActionEvent e) {
		personajeSeleccionado = jugador.getPersonajes().get((int) ((Button)e.getSource()).getUserData());
		vida.setText("Vida: "+personajeSeleccionado.getVida().getVidaActual()+"/"+personajeSeleccionado.getVida().getVidaMaxima());
		ki.setText("Ki: "+personajeSeleccionado.getKi().getMagnitud() );
		btnAccion.setDisable(false);
		btnTransformarse.setDisable(false);
		actualizar();
	}
	
	public void deseleccionarPersonaje() {
		personajeSeleccionado = null;
		btnAccion.setDisable(true);
		btnTransformarse.setDisable(true);
	}
	
	private void actualizar() {
		if (personajeSeleccionado != null){
			nombreUnidad.setText("Unidad: " + personajeSeleccionado.getNombre());
		}
		else
			nombreUnidad.setText("Unidad: <ninguno>");
		for(int i=0;i<3;i++) {
			btnPersonajes[i].setText(jugador.getPersonajes().get(i).getNombre());
		}
		contenedorTablero.actualizar();
	}

	public void clicPasarTurno() {
		jugador = juego.siguienteTurno();
		deseleccionarPersonaje();
		actualizar();
	}
	
	public void clicAccion() {
		Posicionable p = contenedorTablero.getPosicionableSeleccionado();
		Posicion pos = contenedorTablero.getPosicionSeleccionada();
		
		if ((p == null) || (p instanceof Consumible)) {
			try {
				jugador.mover(personajeSeleccionado, pos);
				actualizar();
			} catch (ErrorPosicionInvalida | ErrorUnidadParalizada | ErrorYaMovio e) {
				nombreUnidad.setText("Nope");
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
		
		
			
	}
	
	public void clicTransformarse() {
		try {
			personajeSeleccionado.transformarse();
			actualizar();
		} catch (ErrorNoCumpleReqTrans | ErrorNoHayMasTrans e) {
			nombreUnidad.setText("No te podes transformar wacho");
		}
	}
	
	public void clicAtaqueEspecial(){
		
	}

	public void posicionSeleccionada(Posicion p) {
		nombreUnidad.setText("Seleccionado: " + p.getX() + ";" + p.getY());
		if (personajeSeleccionado == null)
			return;
		btnAccion.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_mover.png"));
	}

	public void personajeSeleccionado(Unidad p) {
		nombreUnidad.setText("Seleccionado: " + p.getNombre());
		if (personajeSeleccionado == null){
			return;
		}
		btnAccion.setGraphic(new ImageView("file:src/view/imagenes/botones/imagen_boton_atacar.png"));
		try{
			Set<Posicion> posiciones = juego.getTablero().getMovimientosPosibles(p.getPosicion(), p.getVelocidad());
			// TODO: incorporar contenedorTablero.marcarPosiciones(posiciones);
		}
		catch (ErrorUnidadParalizada e){
			return;
		}
	}
}

