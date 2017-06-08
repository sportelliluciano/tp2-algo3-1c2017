package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;

public class GokuNormal extends Modo {

	private int costoKi;
	private Modo siguienteModo = new GokuKaioKen();
	//private int velocidadMovimiento = 2;

	@Override
	public boolean puedeTransformarse(Unidad u) {
		return u.getKi().getMagnitud() > this.costoKi;
	}

	@Override
	public Modo transformarA(Unidad u) {
		if (!puedeTransformarse(u)){
			throw new RuntimeException();
		}
		u.getKi().reducirEn(this.costoKi);
		return this.siguienteModo;
	}
}
