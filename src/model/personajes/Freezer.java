package model.personajes;

import model.Unidad;
import model.personajes.modos.FreezerNormal;

public class Freezer extends Unidad {

	public Freezer() {
		vidaMaxima = 400;
		vidaActual = 400;
		
		modo = new FreezerNormal();
	}

}
