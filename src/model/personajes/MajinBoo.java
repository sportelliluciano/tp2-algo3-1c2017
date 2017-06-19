package model.personajes;

import model.Unidad;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.MajinBooNormal;

public class MajinBoo extends Unidad {

	public MajinBoo(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		this.vida = new Vida(300);
		
		modo = new MajinBooNormal();
	}

}
