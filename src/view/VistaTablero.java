package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Posicionable;
import model.Tablero;

public class VistaTablero {
	
	private Tablero tablero;
	private Canvas canvas;
	
	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
	}
	
	public void dibujarPosicionable(GraphicsContext gfc, Posicionable posicionable, double posX, double posY, double ancho, double alto) {
		if (posicionable == null)
			return;
		
		String nombre = posicionable.getNombre().toLowerCase().replaceAll(" ", "-");
		String rutaSprite = "src/view/imagenes/posicionables/" + nombre + ".png";
		Image spritePosicionable = new Image("file:" + rutaSprite);
		
		if (spritePosicionable.isError()) {
			System.out.println(nombre);
			throw new RuntimeException();
		}
		
		gfc.drawImage(spritePosicionable, posX, posY, ancho, alto);
	}
	
	public void dibujar() {
		limpiar();
		GraphicsContext gfc = canvas.getGraphicsContext2D();
		gfc.setFill(Color.web("#c3c3c3"));
		double anchoCasilla = canvas.getWidth() / tablero.getAncho();
		double altoCasilla  = canvas.getHeight() / tablero.getAlto();
		for(int i=0;i<tablero.getAncho();i++) {
			for (int j=0;j<tablero.getAlto();j++) {
				double posX = 0.5 + (i * anchoCasilla);
				double posY = 0.5 + (j * altoCasilla);
				
				gfc.fillRect(posX, posY, anchoCasilla-1, altoCasilla-1);
				dibujarPosicionable(gfc, tablero.getPosicionable(i, j), posX, posY, anchoCasilla - 1, altoCasilla - 1);
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
