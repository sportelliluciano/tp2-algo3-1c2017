package model;

import model.error.ErrorPosicionInvalida;

public class DireccionArriba extends Direccion {
	public Posicion obtenerPosicionNueva(Posicion actual) throws ErrorPosicionInvalida {
		return new Posicion(actual.getX(), actual.getY() - 1);
	}
}
