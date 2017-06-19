package model.personajes;

import model.Unidad;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.personajes.modos.GokuNormal;

public class Goku extends Unidad {
	
	public Goku(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(500);
		
		modo = new GokuNormal();
	}
	
}
