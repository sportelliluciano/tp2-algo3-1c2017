package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class MajinBooOriginal extends Modo {
	public MajinBooOriginal() {
    	nombre = "Boo Original";
    	velocidad = 4;
    	ataqueBasico = new AtaqueBasico(60);
        distanciaDeAtaque = 3;
       
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
