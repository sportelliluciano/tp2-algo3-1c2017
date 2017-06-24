package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GohanSSJFase2 extends GohanNormal {
	
	public GohanSSJFase2(Estado estadoAnterior) {
    	nombre = "Gohan Super Sayajin Fase 2";
    	velocidad = 3;
    	distanciaDeAtaque = 4;
     	poderDePelea = 100;
     	
     	estado = estadoAnterior;
	}
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
