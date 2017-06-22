package model.consumibles;

import model.Consumible;
import model.efectos.BoostEsfera;

public class EsferaDelDragon extends Consumible {
	public EsferaDelDragon(){
		super();
		efectos.add(new BoostEsfera());
	}
	
	public String getNombre() {
		return "Esfera del Dragón";
	}
}
