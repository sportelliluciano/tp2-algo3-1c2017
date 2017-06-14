package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;

public class GokuKaioKen extends Modo {

	private int costoKi = 50;
	private Modo siguienteModo = new GokuSSJ();	
	private int velocidad = 3;

	@Override
	public boolean puedeTransformarse(Unidad u) {
		return u.getKi().getMagnitud() >= this.costoKi;
	}

	@Override
	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans {
		if (!puedeTransformarse(u))
			throw new ErrorNoCumpleReqTrans();
		//u.getKi().reducirEn(this.costoKi);
		return this.siguienteModo;
	}

	@Override
	public String getNombre() {
		return "Kaio-ken";
	}

	@Override
	public int getVelocidad() {
		return velocidad;
	}
}