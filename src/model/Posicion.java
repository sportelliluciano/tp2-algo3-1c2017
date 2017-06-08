package model;

import java.util.ArrayList;

import model.error.ErrorPosicionInvalida;

// La posicion (i,j) en el tablero de un consumible / unidad.
// Podriamos heredar de alguna de java pero javafx.Point2D labura con doubles
// Hay un Point de ints pero en awt; es una libreria obsoleta, mejor no usarla.
public class Posicion {

	public int i,j;
	
	public Posicion(int i, int j) throws ErrorPosicionInvalida {
		if ((i < 0) || (j < 0))
			throw new ErrorPosicionInvalida();
		
		this.i = i;
		this.j = j;
	}
	
	public boolean equals(Posicion other){
		return (this.i == other.i && this.j == other.j);
	}

	public int getX() {
		return this.i;
	}
	
	public int getY() {
		return this.j;
	}
	
	public ArrayList<Posicion> getVecinos() {
		ArrayList<Posicion> lista =  new ArrayList<Posicion>();
		
		try {
			lista.add(new Posicion(Math.max(i-1,0), Math.max(j-1, 0)));
			lista.add(new Posicion(Math.max(i-1,0), j));
			lista.add(new Posicion(Math.max(i-1,0), j+1));
			
			lista.add(new Posicion(i, j+1));
			lista.add(new Posicion(i, Math.max(j-1, 0)));
			
			lista.add(new Posicion(i+1, Math.max(j-1, 0)));
			lista.add(new Posicion(i+1, j));
			lista.add(new Posicion(i+1, j+1));
			
		} catch (ErrorPosicionInvalida e) {	}
		
		return lista;
		
	}
}
