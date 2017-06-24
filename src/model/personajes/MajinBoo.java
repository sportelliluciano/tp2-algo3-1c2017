package model.personajes;

import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.MajinBooNormal;

public class MajinBoo extends Unidad {

	public MajinBoo(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		
		modo = new MajinBooNormal();
	}
}
