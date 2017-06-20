package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class CellPerfecto extends Modo {
	public CellPerfecto() {
    	nombre            = "Cell Perfecto";
    	velocidad         = 4;
    	distanciaDeAtaque = 4;
     	ataqueBasico      = new AtaqueBasico(80);
     	poderDeAtaque = 80;
    }
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		throw new ErrorNoHayMasTrans();
	}
}
