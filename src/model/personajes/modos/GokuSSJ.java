package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuSSJ extends GokuNormal {

	public GokuSSJ(Estado estadoAnterior) {
		nombre            = "Super Saiyajin";
    	velocidad         = 5;
    	distanciaDeAtaque = 4;
    	poderDePelea      = 60;
    	
    	estado = estadoAnterior;
	}
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
	
}

