package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class MajinBooOriginal extends MajinBooNormal {
	public MajinBooOriginal(Estado estadoAnterior) {
    	nombre            = "Boo Original";
    	velocidad         = 4;
    	distanciaDeAtaque = 3;
        poderDePelea      = 60;
        
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
