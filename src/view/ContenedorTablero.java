package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Posicionable;
import model.Tablero;

public class ContenedorTablero extends StackPane {
	private VistaTablero vistaTablero;
	
	public ContenedorTablero(Stage stage, double ancho, double alto, Tablero tablero) {
		Canvas canvasCentral = new Canvas(ancho, alto);
		BorderPane borderPaneTablero = new BorderPane();
		borderPaneTablero.setCenter(canvasCentral);
		this.getChildren().add(borderPaneTablero);
		
		vistaTablero = new VistaTablero(tablero, canvasCentral);
		vistaTablero.dibujar();
	}
	
	public void actualizar() {
		vistaTablero.dibujar();
	}
}
