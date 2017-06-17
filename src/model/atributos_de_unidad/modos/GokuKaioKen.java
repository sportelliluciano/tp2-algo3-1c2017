package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuKaioKen extends Modo {

	private int costoKi = 50;

	public GokuKaioKen() {
		siguienteModo = new GokuSSJ();	
		velocidad = 3;
		distanciaDeAtaque = 4;
		ataqueBasico = 40;	
		nombre = "Kaio-ken";
	}
	
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
	
}