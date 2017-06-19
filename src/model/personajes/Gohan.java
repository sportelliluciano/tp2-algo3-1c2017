package model.personajes;


import model.Unidad;
import model.equipos.GuerrerosZ;
import model.personajes.modos.GohanNormal;

public class Gohan extends Unidad {
	
	public Gohan(GuerrerosZ equipo) {
		this.equipo = equipo;
		vidaMaxima = 300;
		vidaActual = 300;
		modo = new GohanNormal(equipo);
	}

}
