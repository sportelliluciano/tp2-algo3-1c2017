package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GohanNormal extends Modo {

    public GohanNormal() {
    	nombre = "Gohan Normal";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = 20;
        // siguienteModo = new GokuKaioKen();
    }
    
	@Override
	public boolean puedeTransformarse(Unidad u) {
		return false;
	}

	@Override
	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		return null;
	}
}
