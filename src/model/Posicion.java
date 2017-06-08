package model;


import model.error.ErrorPosicionInvalida;

// La posicion (i,j) en el tablero de un consumible / unidad.
// Podriamos heredar de alguna de java pero javafx.Point2D labura con doubles
// Hay un Point de ints pero en awt; es una libreria obsoleta, mejor no usarla.
public class Posicion {
	private int x,y;
	
	public Posicion(int x, int y) throws ErrorPosicionInvalida {
		if ((x < 0) || (y < 0))
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
