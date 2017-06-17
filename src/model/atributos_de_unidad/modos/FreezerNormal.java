package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class FreezerNormal extends Modo {
	
	private int costoKi = 20;

    public FreezerNormal() {
    	nombre = "Freezer Normal";
    	velocidad = 4;
    	ataqueBasico = 20;
        distanciaDeAtaque = 2;
        //siguienteModo = new GokuKaioKen();
    }
    
	@Override
	public boolean puedeTransformarse(Unidad u) {
		return u.getKi().getMagnitud() >= this.costoKi;
	}

	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans  {
		return null;
	
		// TODO Excepcion para no hay mas transformaciones
	}

}
