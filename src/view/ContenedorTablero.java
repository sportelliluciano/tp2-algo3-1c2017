package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Tablero;

public class ContenedorTablero extends BorderPane {
	private VistaTablero vistaTablero;
	
	public ContenedorTablero(Stage stage, double ancho, double alto, Tablero tablero) {
		Canvas canvasCentral = new Canvas(ancho, alto);
		vistaTablero = new VistaTablero(tablero, canvasCentral);
		vistaTablero.dibujar();
		
		this.setCenter(canvasCentral);
	}
}
