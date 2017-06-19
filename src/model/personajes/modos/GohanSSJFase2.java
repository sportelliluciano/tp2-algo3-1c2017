package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.Masenko;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GohanSSJFase2 extends Modo {
	
	public GohanSSJFase2() {
    	nombre = "Gohan Super Sayajin Fase 2";
    	velocidad = 3;
    	distanciaDeAtaque = 4;
     	ataqueBasico = new AtaqueBasico(100);
     	ataqueEspecial = new Masenko(100);
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
