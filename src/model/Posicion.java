package model;

import java.util.HashSet;
import java.util.Set;

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
	
	@Override
	public boolean equals(Object o) {
		Posicion other = (Posicion)o;
		return ((this.x == other.x) && (this.y == other.y));
	}
	
	@Override
	public int hashCode() {
		return (this.x + ";" + this.y).hashCode();
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
	
	public Set<Posicion> getVecinos() {
		Set<Posicion> posicionesVecinas = new HashSet<Posicion>();
		
		try {
			posicionesVecinas.add(new Posicion(Math.max(x-1,0), Math.max(y-1, 0)));
			posicionesVecinas.add(new Posicion(Math.max(x-1,0), y));
			posicionesVecinas.add(new Posicion(Math.max(x-1,0), y+1));
			
			posicionesVecinas.add(new Posicion(x, y+1));
			posicionesVecinas.add(new Posicion(x, Math.max(y-1, 0)));
			
			posicionesVecinas.add(new Posicion(x+1, Math.max(y-1, 0)));
			posicionesVecinas.add(new Posicion(x+1, y));
			posicionesVecinas.add(new Posicion(x+1, y+1));
		} catch (ErrorPosicionInvalida e) {	throw new RuntimeException(); }
		
		posicionesVecinas.remove(this);
		
		return posicionesVecinas;
	}
	
	
}
