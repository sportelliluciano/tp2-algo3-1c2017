package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuNormal extends Modo {

	private int costoKi = 20;
	
    public GokuNormal() {
    	nombre = "Goku Normal";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = 20;
        siguienteModo = new GokuKaioKen();
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
