package model.personajes;

import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.FreezerNormal;

public class Freezer extends Unidad {

	public Freezer(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		vidaMaxima = 400;
		vidaActual = 400;
		
		modo = new FreezerNormal();
	}

}
