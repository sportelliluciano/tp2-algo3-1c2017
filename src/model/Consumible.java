package model;

import java.util.ArrayList;

import model.efectos.Efecto;

// Una semilla, nube voladora o esfera.
public abstract class Consumible extends Posicionable {
	public ArrayList<Efecto> efectos;
	
	public Consumible(){
		this.efectos = new ArrayList<Efecto>();
	}
	
	public ArrayList<Efecto> getEfectos(){
		return efectos;
	}
	
	public int getIncrementoVida() {
		return 0;
	}

	public int getCantidadEsferasDelDragon() {
		return 0;
	}

	@Override
	public Consumible pisar() {
		return this;
	}
}
