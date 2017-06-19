package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class PiccoloProtector extends Modo {

	public PiccoloProtector() {
		nombre = "Piccolo Protector";
    	velocidad = 4;
    	distanciaDeAtaque = 6;
     	ataqueBasico = new AtaqueBasico(60);
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {

		throw new ErrorNoHayMasTrans();
	}
}
