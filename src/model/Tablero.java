package model;

import java.util.ArrayList;

public class Tablero {
	private ArrayList<Posicionable> posicionables = new ArrayList<Posicionable>();
		
	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) {
		unidad.moverA(nuevaPosicion);
	}

	public void agregar(Posicionable posicionable) {
		posicionables.add(posicionable);
	}
}
