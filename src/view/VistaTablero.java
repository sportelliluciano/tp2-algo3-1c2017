package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Tablero;

public class VistaTablero {
	
	private Tablero tablero;
	private Canvas canvas;
	
	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
	}
	
	public void dibujar() {
		limpiar();
		GraphicsContext gfc = canvas.getGraphicsContext2D();
		gfc.setFill(Color.web("#c3c3c3"));
		double anchoCasilla = canvas.getWidth() / tablero.getAncho();
		double altoCasilla  = canvas.getHeight() / tablero.getAlto();
		for(int i=0;i<tablero.getAncho();i++) {
			for (int j=0;j<tablero.getAlto();j++) {
				gfc.fillRect(0.5 + (i * anchoCasilla), 0.5 + (j * altoCasilla), anchoCasilla-1, altoCasilla-1);
			}
		}
	}
	
	public void limpiar() {
		GraphicsContext gfc = canvas.getGraphicsContext2D();
		gfc.setFill(Color.BLACK);
		gfc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void actualizar() {
		
	}
}
