package model.personajes;


import model.Unidad;
import model.personajes.modos.GohanNormal;

public class Gohan extends Unidad {
	
	public Gohan() {
		vidaMaxima = 300;
		vidaActual = 300;
		modo = new GohanNormal();
	}

}
