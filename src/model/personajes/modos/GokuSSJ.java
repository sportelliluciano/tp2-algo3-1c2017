package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuSSJ extends Modo {

	public GokuSSJ() {
		nombre            = "Super Saiyajin";
    	velocidad         = 5;
    	distanciaDeAtaque = 4;
     	ataqueBasico      = new AtaqueBasico(60);
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}

