package model.personajes;

import model.Unidad;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.FreezerNormal;

public class Freezer extends Unidad {

	public Freezer(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		this.vida = new Vida(400);
		
		modo = new FreezerNormal();
	}

}
