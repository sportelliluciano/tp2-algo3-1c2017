package model;

import java.util.List;
import java.util.ArrayList;

public class Tablero {
	private List<Posicionable> posicionables = new ArrayList<Posicionable>();
	
	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(nuevaPosicion)){
				unidad.ocuparLugarDe(p);
				return;
			}
		}
		unidad.moverA(nuevaPosicion);
	}

	public void agregarUnidad(Unidad unidad, Posicion posicion) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(posicion)){
				unidad.ocuparLugarDe(p);
			}
		}
		unidad.setPosicion(posicion);
		posicionables.add(unidad);
	}
}
