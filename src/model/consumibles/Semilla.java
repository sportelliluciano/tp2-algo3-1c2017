package model.consumibles;

import model.Consumible;

public class Semilla extends Consumible {
	
	public int getIncrementoVida() {
		return 100;
	}
	
	public String getNombre() {
		return "Semilla del Ermitaño";
	}
}
