package model;

import java.util.List;

import model.error.ErrorPosicionInvalida;

import java.util.ArrayList;

public class Tablero {
	private List<Posicionable> posicionables = new ArrayList<Posicionable>();
	private int ancho, alto;
	
	public Tablero (int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void moverUnidad(Unidad unidad, Direccion dir) throws ErrorPosicionInvalida {
		Posicion nuevaPosicion = dir.obtenerPosicionNueva(unidad.getPosicion());
		if ( !posicionEstaLibre(nuevaPosicion) )
			throw new ErrorPosicionInvalida();
		unidad.setPosicion(nuevaPosicion);
	}
	
	public boolean posicionEstaLibre(Posicion pos) {
		return ( !hayUnidadEnPosicion(pos) && pos.estaDentroDelLimite(this.ancho, this.alto) );
	}
	
	public boolean hayUnidadEnPosicion(Posicion pos) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(pos))
				return true;
		}
		
		return false;
	}

	public void agregarUnidad(Unidad unidad, Posicion posicion) throws ErrorPosicionInvalida {
		if (!posicionEstaLibre(posicion))
			throw new ErrorPosicionInvalida();
		
		unidad.setPosicion(posicion);
		posicionables.add(unidad);
	}
	
}
