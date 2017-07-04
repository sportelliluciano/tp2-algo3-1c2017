package view;

import java.io.File;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.Juego;
import model.Posicion;
import model.Posicionable;
import model.Unidad;

public class ContenedorJuego extends BorderPane {

	private Juego juego;
	private ContenedorHUD contenedorHUD;
	private ContenedorTablero contenedorTablero;
	
	public ContenedorJuego(Juego juego) {
		this.juego = juego;
		contenedorTablero = new ContenedorTablero(this, 800, 600 * 0.8, juego.getTablero());
		this.contenedorHUD = new ContenedorHUD(juego, contenedorTablero, 600 * 0.2);
		setCenter(contenedorTablero);
		setBottom(contenedorHUD);
		redimensionar(800, 600);
	}
	
	public void iniciarJuego() {
		MediaPlayer sonidoFondo = new MediaPlayer(new Media(new File("src/view/sonidos/background.mp3").toURI().toString()));
		sonidoFondo.setOnEndOfMedia(new Runnable() {
			public void run() {
				sonidoFondo.seek(Duration.ZERO);
			}
		});
		sonidoFondo.play();
	}
	
	public void redimensionar(double nuevoAncho, double nuevoAlto) {
		contenedorTablero.redimensionar(nuevoAncho, nuevoAlto * 0.8);
	}

	public void personajeSeleccionado(Posicionable p) {
		if(p instanceof Unidad)
			contenedorHUD.personajeSeleccionado((Unidad)p);
		else
			posicionSeleccionada(p.getPosicion());
	}
	
	public void posicionSeleccionada(Posicion p) {
		contenedorHUD.posicionSeleccionada(p);
	}
	
	public Posicion getPosicionSeleccionada() {
		return contenedorTablero.getPosicionSeleccionada();
	}

	public Posicion getPosicionCentral() {
		return contenedorTablero.getPosicionCentral();
	}
	
	public void seleccionarPosicion(Posicion pos) {
		contenedorTablero.seleccionarPosicion(pos);
		contenedorHUD.posicionSeleccionada(pos);
	}
	
	public void clicTransformarse() {
		contenedorHUD.clicTransformarse();
	}

	public void clicAccion() {
		contenedorHUD.clicAccion();
	}

	public void clicAtaqueEspecial() {
		contenedorHUD.clicAtaqueEspecial();
	}

	public void clicPasarTurno() {
		contenedorHUD.clicPasarTurno();
		
	}
	
}
