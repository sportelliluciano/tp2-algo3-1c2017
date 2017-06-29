package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.Posicion;
import model.Posicionable;
import model.Tablero;

public class VistaTablero {
	
	private Tablero tablero;
	private Canvas canvas;
	private double anchoCasilla, altoCasilla;
	private Posicion posSeleccionada = null;
	
	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
	}
	
	public void dibujarPosicionable(GraphicsContext gfc, Posicionable posicionable, double posX, double posY, double maxAncho, double maxAlto) {
		if (posicionable == null)
			return;
		
		Image spritePosicionable = FabricaSprites.getSpritePosicionable(posicionable);
		double anchoSprite = spritePosicionable.getWidth(),
				altoSprite = spritePosicionable.getHeight();
		double margenX = 0, margenY = 0;
		double alto = 0, ancho = 0;
		
		if (altoSprite < anchoSprite) {
			ancho = Math.min(maxAncho, anchoSprite);
			alto = altoSprite * (ancho / anchoSprite);
			margenY = (maxAlto - alto) / 2;
		}
		else {
			alto = Math.min(maxAlto, altoSprite);
			ancho = anchoSprite * (alto / altoSprite);
			margenX = (maxAncho - ancho) / 2;
		}
		
		gfc.drawImage(spritePosicionable, posX + margenX, posY + margenY, ancho, alto);
	}
	
	public void redimensionar(double ancho, double alto) {
		canvas.setWidth(ancho);
		canvas.setHeight(alto);
	}
	
	public void dibujar() {
		limpiar();
		GraphicsContext gfc = canvas.getGraphicsContext2D();
		gfc.setFill(Color.web("#c3c3c3"));
		anchoCasilla = (canvas.getWidth() - 16) / tablero.getAncho(); // Ni idea xq ese 16 es necesario pero sino se queda corta la ultima fila
		altoCasilla  = (canvas.getHeight()) / tablero.getAlto();
		for(int i=0;i<tablero.getAncho();i++) {
			for (int j=0;j<tablero.getAlto();j++) {
				double posX = 0.5 + (i * anchoCasilla);
				double posY = 0.5 + (j * altoCasilla);
				
				if ((posSeleccionada != null) && (posSeleccionada.equals(new Posicion(i,j))))
					gfc.setFill(Color.web("#ffffff"));
				else
					gfc.setFill(Color.web("#c3c3c3"));
				
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

	public Posicionable getPosicionable(double x, double y) {
		Posicion p = getPosicion(x, y);
		if (p == null)
			return null;
		return tablero.getPosicionable(p.getX(), p.getY());
	}

	public Posicion getPosicion(double x, double y) {
		
		return new Posicion((int) (x / anchoCasilla), (int) (y/altoCasilla));
		/*
		for(int i=0;i<tablero.getAncho();i++) {
			for (int j=0;j<tablero.getAlto();j++) {
				double posX = 0.5 + (i * anchoCasilla);
				double posY = 0.5 + (j * altoCasilla);
				
				if ((posX <= x) && (x <= (posX + anchoCasilla - 1))) {
					if ((posY <= y) && (y <= (posY + altoCasilla - 1))) {
						return new Posicion(i, j);
					}
				}
			}
		}
		return null;*/
	}
	
	public void setSeleccionada(Posicion p) {
		posSeleccionada = p;
	}
}
