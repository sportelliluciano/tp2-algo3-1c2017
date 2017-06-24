package model.personajes;

import model.Unidad;
import model.equipos.GuerrerosZ;
import model.personajes.modos.PiccoloNormal;

public class Piccolo extends Unidad {
	
	public Piccolo(GuerrerosZ equipo) {
		this.equipo = equipo;
		
		modo = new PiccoloNormal(equipo);
	}
}
