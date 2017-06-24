package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class FreezerDefinitivo extends FreezerNormal {
	public FreezerDefinitivo(Estado estadoAnterior) {
    	nombre            = "Freezer Definitivo";
    	velocidad         = 6;
    	distanciaDeAtaque = 3;
    	poderDePelea      = 50;
    	
    	estado = estadoAnterior;
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
