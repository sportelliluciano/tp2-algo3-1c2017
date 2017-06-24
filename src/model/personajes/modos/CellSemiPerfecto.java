package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class CellSemiPerfecto extends CellNormal {
	
	public CellSemiPerfecto(Estado estadoAnterior, int vidaAbsorbida) {
		nombre            = "Cell Semi-perfecto";
    	velocidad         = 3;
    	distanciaDeAtaque = 4;
    	poderDePelea      = 40;
    	
		estado             = estadoAnterior;
		this.vidaAbsorbida = vidaAbsorbida;
	}

	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (vidaAbsorbida < 8)
			throw new ErrorNoCumpleReqTrans();

		return new CellPerfecto(estado);
	}
}
