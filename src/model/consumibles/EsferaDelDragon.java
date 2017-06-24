package model.consumibles;

import model.Consumible;
import model.efectos.EfectoEsferaDelDragon;

public class EsferaDelDragon extends Consumible {
	public EsferaDelDragon(){
		super();
		efectos.add(new EfectoEsferaDelDragon());
	}
	
	public String getNombre() {
		return "Esfera del Dragón";
	}
	
	@Override
	public int getCantidadEsferasDelDragon() {
		return 1;
	}
}
