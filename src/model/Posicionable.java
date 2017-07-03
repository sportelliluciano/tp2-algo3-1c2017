package model;

import model.consumibles.ConsumibleVacio;
import model.error.ErrorUnidadNoSePuedePisar;

public abstract class Posicionable {

	private Posicion posicion;
		
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public abstract String getNombre();

	public Consumible pisar() throws ErrorUnidadNoSePuedePisar {
		return new ConsumibleVacio();
	}
}
