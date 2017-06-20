package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.ConvierteteEnChocolate;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class MajinBooOriginal extends Modo {
	public MajinBooOriginal() {
    	nombre = "Boo Original";
    	velocidad = 4;
    	distanciaDeAtaque = 3;
    	ataqueBasico = new AtaqueBasico(60);
        ataqueEspecial = new ConvierteteEnChocolate();
        poderDeAtaque = 60;
        
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
