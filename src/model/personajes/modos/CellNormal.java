package model.personajes.modos;

import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class CellNormal extends Modo {
	
	private int vidaAbsorbida = 0;
	
	public CellNormal() {
    	nombre            = "Cell Normal";
    	velocidad         = 2;
    	distanciaDeAtaque = 3;
     	ataqueBasico      = new AtaqueBasico(20);
     	
        siguienteModo     = new CellSemiPerfecto();
    }
	
	@Override
	public Ataque getAtaqueEspecial() {
		vidaAbsorbida++;
		return super.getAtaqueEspecial();
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (vidaAbsorbida < 4)
			throw new ErrorNoCumpleReqTrans();
		
		return siguienteModo;
	}
}
