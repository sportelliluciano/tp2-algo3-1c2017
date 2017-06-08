package model;

import model.error.ErrorPosicionInvalida;

public abstract class Direccion {
	public abstract Posicion obtenerPosicionNueva(Posicion actual) throws ErrorPosicionInvalida;
}
