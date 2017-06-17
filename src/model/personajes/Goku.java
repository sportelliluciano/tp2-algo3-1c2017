package model.personajes;

import model.Unidad;
import model.personajes.modos.GokuNormal;

public class Goku extends Unidad {

	public Goku() {
		vidaMaxima = 500;
		vidaActual = 500;
		modo = new GokuNormal();
	}
}
