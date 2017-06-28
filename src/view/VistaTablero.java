package view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Posicion;
import model.Posicionable;
import model.Tablero;

public class VistaTablero {
	
	private Tablero tablero;
	private Canvas canvas;
	private double anchoCasilla, altoCasilla;
	private Posicion posSeleccionada = null;
	private Map<String, Image> imagenes;
	
	public VistaTablero(Tablero tablero, Canvas canvas) {
		this.tablero = tablero;
		this.canvas = canvas;
		imagenes = new HashMap<String, Image>();
	}
	
	public void dibujarPosicionable(GraphicsContext gfc, Posicionable posicionable, double posX, double posY, double ancho, double alto) {
		if (posicionable == null)
			return;
		
		String nombre = posicionable.getNombre().toLowerCase().replaceAll(" ", "-");
		String rutaSprite = "src/view/imagenes/posicionables/" + nombre + ".png";
		Image spritePosicionable = imagenes.get(rutaSprite);
		if (spritePosicionable == null) {
			spritePosicionable = new Image("file:" + rutaSprite);
			imagenes.put(rutaSprite, spritePosicionable);
		}
		
		if (spritePosicionable.isError()) {
			System.out.println(nombre);
			throw new RuntimeException();
		}
		
		gfc.drawImage(spritePosicionable, posX, posY, ancho, alto);
	}
	
	public void redimensionar(double ancho, double alto) {
		canvas.setWidth(ancho);
		canvas.setHeight(alto);
	}
	
	public void dibujar() {
		limpiar();
		GraphicsContext gfc = canvas.getGraphicsContext2D();
		gfc.setFill(Color.web("#c3c3c3"));
		anchoCasilla = canvas.getWidth() / tablero.getAncho();
		altoCasilla  = canvas.getHeight() / tablero.getAlto();
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
		return null;
	}
	
	public void setSeleccionada(Posicion p) {
		posSeleccionada = p;
	}
}
