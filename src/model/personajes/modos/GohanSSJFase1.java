package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.Masenko;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class GohanSSJFase1 extends Modo {
	
	private GuerrerosZ equipo;
	
	public GohanSSJFase1(GuerrerosZ equipo) {
    	nombre = "Gohan Super Sayajin fase 1";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = new AtaqueBasico(30);
     	ataqueEspecial = new Masenko(30);
        
     	this.equipo = equipo;
     	siguienteModo = new GohanSSJFase2();
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		Goku goku = equipo.getGoku();
		Piccolo piccolo = equipo.getPiccolo();
		
		if (goku.getPorcentajeVida() > 30)
			throw new ErrorNoCumpleReqTrans();
		
		if (piccolo.getPorcentajeVida() > 30)
			throw new ErrorNoCumpleReqTrans();
		
		return siguienteModo;
	}
}
