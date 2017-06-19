package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class FreezerDefinitivo extends Modo {
	public FreezerDefinitivo() {
    	nombre = "Freezer Definitivo";
    	velocidad = 6;
    	distanciaDeAtaque = 3;
    	ataqueBasico = new AtaqueBasico(50);
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
