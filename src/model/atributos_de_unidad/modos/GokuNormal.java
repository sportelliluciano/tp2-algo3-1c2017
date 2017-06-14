package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuNormal extends Modo {

	private int costoKi = 20;
	private Modo siguienteModo = new GokuKaioKen();
	private int velocidad = 2;

	@Override
	public boolean puedeTransformarse(Unidad u) {
		return u.getKi().getMagnitud() >= this.costoKi;
	}

	@Override
	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (!puedeTransformarse(u))
			throw new ErrorNoCumpleReqTrans();
		//u.getKi().reducirEn(this.costoKi);
		return this.siguienteModo;
	}

	@Override
	public String getNombre() {
		return "Normal";
	}

	@Override
	public int getVelocidad() {
		return velocidad;
	}
}
