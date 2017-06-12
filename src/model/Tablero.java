package model;

import java.util.List;

import model.error.ErrorPosicionInvalida;

import java.util.ArrayList;

public class Tablero {
	private List<Posicionable> posicionables = new ArrayList<Posicionable>();
	private int alto;
	private int ancho;
	
	public Tablero (int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public boolean hayPosicionableEn(Posicion pos) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(pos))
				return true;
		}
		
		return false;
	}

	public void agregarUnidad(Unidad unidad, Posicion posicion) throws ErrorPosicionInvalida {
		validarPosicion(posicion);
		if (hayPosicionableEn(posicion))
			throw new ErrorPosicionInvalida();
		
		unidad.setPosicion(posicion);
		posicionables.add(unidad);
	}

	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) throws ErrorPosicionInvalida {
		validarPosicion(nuevaPosicion);
		unidad.moverA(nuevaPosicion, this);
	}
	
	public void validarPosicion(Posicion posicion) throws ErrorPosicionInvalida {
		if ( (posicion.getX() < 0) || (posicion.getY() < 0) )
			throw new ErrorPosicionInvalida();
		if ( (posicion.getX() > this.ancho) || (posicion.getY() > this.alto) )
			throw new ErrorPosicionInvalida();
	}
	
}
