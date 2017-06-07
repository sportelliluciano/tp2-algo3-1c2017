package model;

public abstract class Posicionable {

	private Posicion posicion;
		
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}

	public void serOcupadoPor(Unidad unidad) {
		
	}
}
