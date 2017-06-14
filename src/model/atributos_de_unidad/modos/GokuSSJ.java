package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;

public class GokuSSJ extends Modo {

	private int velocidad = 5;

	@Override
	public boolean puedeTransformarse(Unidad u) {
		return false;
	}

	@Override
	public Modo transformarA(Unidad u) { throws ErrorNoHayMasTrans
		// TODO Excepcion para no hay mas transformaciones
		throw new ErrorNoHayMasTrans();
	}

	@Override
	public String getNombre() {
		return "Super Saiyajin";
	}

	@Override
	public int getVelocidad() {
		return velocidad ;
	}
}

