package model.consumibles;

import model.Consumible;
import model.efectos.EfectoNubeVoladora;

public class NubeVoladora extends Consumible {
	public NubeVoladora(){
		super();
		efectos.add(new EfectoNubeVoladora());
	}
	
	public String getNombre() {
		return "Nube voladora";
	}
}
