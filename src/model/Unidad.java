package model;

import model.atributos_de_unidad.*;

// Uno de los 3 tipitos que maneja el jugador.
public class Unidad extends Posicionable {

	private Modo modo;
	
	public Unidad(Modo modo, Posicion posicion) {
		super(posicion);
		this.modo = modo;
	}

	public void moverA(Posicion nuevaPosicion) {
		// TODO: Chequear que pueda moverse ahi (la prueba 01 no lo contempla)
		setPosicion(nuevaPosicion);
	}

}
