package model.personajes;


import model.Unidad;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.personajes.modos.GohanNormal;

public class Gohan extends Unidad {
	
	public Gohan(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(300);
		
		modo = new GohanNormal(equipo);
	}

}
