package model.consumibles;

import model.Consumible;
import model.efectos.BoostVelocidad;

public class NubeVoladora extends Consumible {
	public NubeVoladora(){
		super();
		efectos.add(new BoostVelocidad(2, 100));
	}
}
