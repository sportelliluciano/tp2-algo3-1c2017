package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;

public class GokuKaioKen extends Modo {

	@Override
	public boolean puedeTransformarse(Unidad u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Modo transformarA(Unidad u) {
		// TODO Auto-generated method stub
		return new GokuSSJ();
	}

}
