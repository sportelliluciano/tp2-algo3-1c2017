package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class CellPerfecto extends CellNormal {
	public CellPerfecto(Estado estadoAnterior) {
    	nombre            = "Cell Perfecto";
    	velocidad         = 4;
    	distanciaDeAtaque = 4;
     	poderDePelea      = 80;
     	
     	estado = estadoAnterior;
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
