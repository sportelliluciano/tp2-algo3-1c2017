package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class PiccoloProtector extends PiccoloNormal {

	public PiccoloProtector(Estado estadoAnterior) {
		nombre            = "Piccolo Protector";
    	velocidad         = 4;
    	distanciaDeAtaque = 6;
     	poderDePelea      = 60;
     	
     	estado = estadoAnterior;
	}
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
