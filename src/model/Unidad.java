package model;

import model.atributos_de_unidad.*;

// Uno de los 3 tipitos que maneja el jugador.
public class Unidad extends Posicionable {

	private Modo modo;
	
	public Unidad(Modo modo) {
		this.modo = modo;
	}

	public void moverA(Posicion nuevaPosicion) {
		setPosicion(nuevaPosicion);
	}

	public void ocuparLugarDe(Posicionable p) {
		p.serOcupadoPor(this);
	}
	
	@Override
	public void serOcupadoPor(Unidad u) {
		
		throw new RuntimeException();
		
	}
}
