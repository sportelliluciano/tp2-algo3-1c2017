package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuSSJ extends Modo {

	public GokuSSJ() {
		nombre = "Goku Super Saiyajin";
    	velocidad = 5;
    	distanciaDeAtaque = 4;
     	ataqueBasico = 60;
        siguienteModo = null;
	}
	
	@Override
	public boolean puedeTransformarse(Unidad u) {
		return false;
	}

	@Override
	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans { 
		throw new ErrorNoHayMasTrans();
	}
}

