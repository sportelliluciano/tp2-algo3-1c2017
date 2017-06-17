package model;

import java.util.ArrayList;
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
	
    public Posicion add(Posicion other) {
    	int nuevo_x = this.getX() + other.getX();
    	int nuevo_y = this.getY() + other.getY();
    	
    	return new Posicion(nuevo_x, nuevo_y);
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
	
	public Set<Posicion> getVecinos(ArrayList<Direccion> direcciones) {
		Set<Posicion> posicionesVecinas = new HashSet<Posicion>();
		
		for(Direccion d: direcciones)
			posicionesVecinas.add(d.obtenerPosicionNueva(this));
		
		return posicionesVecinas;
	}
	
}
