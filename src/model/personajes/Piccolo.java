package model.personajes;

import model.Unidad;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.personajes.modos.PiccoloNormal;

public class Piccolo extends Unidad {
	
	public Piccolo(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(500);
		
		modo = new PiccoloNormal(equipo);
	}

}
