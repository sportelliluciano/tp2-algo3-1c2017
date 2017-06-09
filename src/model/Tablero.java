package model;

import java.util.List;

import model.error.ErrorPosicionInvalida;

import java.util.ArrayList;

public class Tablero {
	private List<Posicionable> posicionables = new ArrayList<Posicionable>();
	
	public Tablero (int ancho, int alto) {
		Posicion.setLimites(ancho, alto);
	}
	
	public boolean hayUnidadEn(Posicion pos) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(pos))
				return true;
		}
		
		return false;
	}

	public void agregarUnidad(Unidad unidad, Posicion posicion) throws ErrorPosicionInvalida {
		if (hayUnidadEn(posicion))
			throw new ErrorPosicionInvalida();
		
		unidad.setPosicion(posicion);
		posicionables.add(unidad);
	}

	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) throws ErrorPosicionInvalida {
		unidad.moverA(nuevaPosicion, this);
	}
	
}
