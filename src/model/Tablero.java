package model;

import java.util.ArrayList;

public class Tablero {
	private ArrayList<Posicionable> posicionables = new ArrayList<Posicionable>();
		
	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) {
		unidad.moverA(nuevaPosicion);
	}

	public void agregarUnidad(Unidad u, Posicion posicion) {
		for (Posicionable p: posicionables)
			if (p.getPosicion().equals(posicion))
				u.ocuparLugarDe(p);
		posicionables.add(u);
	}
}
