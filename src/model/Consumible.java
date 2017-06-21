package model;

import java.util.ArrayList;

import model.efectos.Efecto;

// Una semilla, nube voladora o esfera.
public class Consumible extends Posicionable {
	public ArrayList<Efecto> efectos;
	
	public Consumible(){
		this.efectos = new ArrayList();
	}
	public ArrayList<Efecto> efectos(){
		return efectos;
	}
	

}
