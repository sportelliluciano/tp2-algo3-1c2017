package model.personajes;

import model.Unidad;
import model.equipos.GuerrerosZ;
import model.personajes.modos.GokuNormal;

public class Goku extends Unidad {
	
	public Goku(GuerrerosZ equipo) {
		this.equipo = equipo;
		
		modo = new GokuNormal();
	}
	
}
