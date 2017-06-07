package model;

public abstract class Posicionable {

	private Posicion posicion;
	
	public Posicionable(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
}
