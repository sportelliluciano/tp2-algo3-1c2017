package model;

import java.util.HashSet;
import java.util.Set;

// La posicion (i,j) en el tablero de un consumible / unidad.

public class Posicion {
	private int x,y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Posicion))
			return false;
		if (o == this)
			return true;
		
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
		
		
		posicionesVecinas.add(new Posicion(x-1, y-1));
		posicionesVecinas.add(new Posicion(x-1, y));
		posicionesVecinas.add(new Posicion(x-1, y+1));
		
		posicionesVecinas.add(new Posicion(x, y+1));
		posicionesVecinas.add(new Posicion(x, y-1));
		
		posicionesVecinas.add(new Posicion(x+1, y-1));
		posicionesVecinas.add(new Posicion(x+1, y));
		posicionesVecinas.add(new Posicion(x+1, y+1));
		
		return posicionesVecinas;
	}
	
	
}
