package model.personajes.modos;

import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class CellSemiPerfecto extends Modo {
	
	private int vidaAbsorbida = 0;
	
	public CellSemiPerfecto() {
    	nombre            = "Cell Semi-perfecto";
    	velocidad         = 3;
    	distanciaDeAtaque = 4;
     	ataqueBasico      = new AtaqueBasico(40);
     	poderDeAtaque = 40;
     	
        siguienteModo     = new CellPerfecto();
    }
	
	@Override
	public Ataque getAtaqueEspecial() {
		vidaAbsorbida++;
		return ataqueBasico;
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (vidaAbsorbida < 8)
			throw new ErrorNoCumpleReqTrans();
		
		return siguienteModo;
	}
}
