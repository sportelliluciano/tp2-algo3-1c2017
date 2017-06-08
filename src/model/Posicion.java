package model;

// La posicion (i,j) en el tablero de un consumible / unidad.
// Podriamos heredar de alguna de java pero javafx.Point2D labura con doubles
// Hay un Point de ints pero en awt; es una libreria obsoleta, mejor no usarla.
public class Posicion {

	public int i,j;
	
	public Posicion(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public boolean equals(Posicion other){
		return (this.i == other.i && this.j == other.j);
	}

	public int getX() {
		// TODO Auto-generated method stub
		return this.i;
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return this.j;
	}
}
