package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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

public class ContenedorHUD extends BorderPane {

	private ImageView personaje;
	private VBox botoneraAcciones, botoneraPersonajes;
	private Button btnPasarTurno, btnAccion, btnTransformarse;
	private Button btnPersonajes[];
	private Juego juego;
	private Jugador jugador;
	private Label label;
	private Unidad personajeSeleccionado;
	private ContenedorTablero contenedorTablero;
	
	public ContenedorHUD(Juego juego, ContenedorTablero contenedorTablero) {
		this.juego = juego;
		this.jugador = juego.getJugadorActual();
		personaje = new ImageView(new Image("file:src/view/imagenes/posicionables/goku-normal.png"));
		label = new Label();
		botoneraAcciones = new VBox();
		botoneraPersonajes = new VBox();
		
		this.contenedorTablero = contenedorTablero;
		
		btnPersonajes = new Button[3];
		
		for(int i=0;i<3;i++) {
			btnPersonajes[i] = new Button(jugador.getPersonajes().get(i).getNombre());
			btnPersonajes[i].setUserData(i);
			btnPersonajes[i].setOnAction(e -> seleccionarPersonaje(e));
			botoneraPersonajes.getChildren().add(btnPersonajes[i]);
		}
		
		btnPasarTurno = new Button("Pasar turno");
		btnAccion = new Button("Atacar/Mover");
		btnTransformarse = new Button("Transformar");
		btnPasarTurno.setOnAction(e -> clicPasarTurno() );
		btnAccion.setOnAction(e -> clicAccion() );
		btnTransformarse.setOnAction(e -> clicTransformarse() );
		botoneraAcciones.getChildren().add(btnPasarTurno);
		botoneraAcciones.getChildren().add(btnAccion);
		botoneraAcciones.getChildren().add(btnTransformarse);
		this.setRight(botoneraAcciones);
		this.setLeft(botoneraPersonajes);
		this.setCenter(label);
		deseleccionarPersonaje();
	}
	
	public void seleccionarPersonaje(ActionEvent e) {
		personajeSeleccionado = jugador.getPersonajes().get((int) ((Button)e.getSource()).getUserData());
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
		if (personajeSeleccionado != null)
			label.setText("Unidad: " + personajeSeleccionado.getNombre());
		else
			label.setText("Unidad: <ninguno>");
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
				personajeSeleccionado.moverA(pos, juego.getTablero());
				actualizar();
			} catch (ErrorPosicionInvalida | ErrorUnidadParalizada e) {
				label.setText("Nope");
			}
		}
		else if(p instanceof Unidad) {
			try {
				personajeSeleccionado.ataqueBasicoA((Unidad)p, juego.getTablero());
				actualizar();
			} catch (ErrorUnidadParalizada | ErrorUnidadNoEsEnemiga | ErrorEnemigoFueraDeAlcance
					| ErrorPosicionInvalida e) {
				label.setText("Nope");
			}
		}
		
		
			
	}
	
	public void clicTransformarse() {
		try {
			personajeSeleccionado.transformarse();
			actualizar();
		} catch (ErrorNoCumpleReqTrans | ErrorNoHayMasTrans e) {
			label.setText("No te podes transformar wacho");
		}
	}

	public void posicionSeleccionada(Posicion p) {
		label.setText("Seleccionado: " + p.getX() + ";" + p.getY());
		if (personajeSeleccionado == null)
			return;
		btnAccion.setText("Mover");
	}

	public void personajeSeleccionado(Unidad p) {
		label.setText("Seleccionado: " + p.getNombre());
		if (personajeSeleccionado == null)
			return;
		btnAccion.setText("Atacar");
	}
}
