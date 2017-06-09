package model;

import model.error.ErrorPosicionInvalida;

// La posicion (i,j) en el tablero de un consumible / unidad.

public class Posicion {
	private int x,y;
	
	private static int maxX, maxY;
	
	public static void setLimites(int limiteX, int limiteY) {
		maxX = limiteX;
		maxY = limiteY;
	}
	
	public Posicion(int x, int y) throws ErrorPosicionInvalida {
		if ((x < 0) || (y < 0) || (x > maxX) || (y > maxY))
			throw new ErrorPosicionInvalida();
		
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Posicion other) {
		return (this.x == other.x && this.y == other.y);
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public boolean estaDentroDelLimite(int limiteX, int limiteY) {
		return (this.x < limiteX) && (this.y < limiteY);
	}

}
