package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.Posicion;
import model.Posicionable;
import model.Tablero;

public class ContenedorTablero extends StackPane {
	private VistaTablero vistaTablero;
	private ContenedorJuego contenedorJuego;
	private Tablero tablero;
	private Posicion ultimoClick;
	
	public ContenedorTablero(ContenedorJuego contenedorJuego, double ancho, double alto, Tablero tablero) {

		this.contenedorJuego = contenedorJuego;
		this.tablero = tablero;
		
		Canvas canvasCentral = new Canvas(ancho, alto);
		canvasCentral.setOnMouseClicked(e -> canvasClick(e));
		BorderPane borderPaneTablero = new BorderPane();
		borderPaneTablero.setCenter(canvasCentral);
		this.getChildren().add(borderPaneTablero);
		
		vistaTablero = new VistaTablero(tablero, canvasCentral);
		vistaTablero.dibujar();
	
	}	
	
	private void canvasClick(MouseEvent e) {
		Posicionable p = vistaTablero.getPosicionable(e.getX(), e.getY());
		Posicion pos = vistaTablero.getPosicion(e.getX(), e.getY());
		if (p == null)
			contenedorJuego.posicionSeleccionada(pos);
		else
			contenedorJuego.personajeSeleccionado(p);
		
		ultimoClick = pos;
		vistaTablero.setSeleccionada(pos);
		vistaTablero.dibujar();
	}


	public void redimensionar(double ancho, double alto) {
		
		vistaTablero.redimensionar(ancho, alto);
		vistaTablero.dibujar();
		//crear(contenedorJuego, ancho, alto, tablero);
	}

	public void actualizar() {
		vistaTablero.dibujar();
	}

	public Posicionable getPosicionableSeleccionado() {
		return tablero.getPosicionable(ultimoClick.getX(), ultimoClick.getY());
	}

	public Posicion getPosicionSeleccionada() {
		return ultimoClick;
	}
}
