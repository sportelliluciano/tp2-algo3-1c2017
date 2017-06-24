package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class GohanSSJFase1 extends GohanNormal {
	
	private GuerrerosZ equipo;
	
	public GohanSSJFase1(Estado estadoAnterior, GuerrerosZ equipo) {
    	nombre = "Gohan Super Sayajin fase 1";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	poderDePelea = 30;
     	
     	this.equipo = equipo;
     	estado = estadoAnterior;
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		Goku goku = equipo.getGoku();
		Piccolo piccolo = equipo.getPiccolo();
		
		if (goku.getVida().getPorcentajeVida() > 30)
			throw new ErrorNoCumpleReqTrans();
		
		if (piccolo.getVida().getPorcentajeVida() > 30)
			throw new ErrorNoCumpleReqTrans();
		
		return new GohanSSJFase2(estado);
	}
}
