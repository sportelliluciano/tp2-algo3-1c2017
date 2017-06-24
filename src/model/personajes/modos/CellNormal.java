package model.personajes.modos;

import model.Unidad;
import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class CellNormal extends Modo {
	
	protected int vidaAbsorbida = 0;
	
	public CellNormal() {
    	nombre            = "Cell Normal";
    	velocidad         = 2;
    	distanciaDeAtaque = 3;
     	poderDePelea      = 20;
     	
     	estado = new Estado(500);
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (vidaAbsorbida < 4)
			throw new ErrorNoCumpleReqTrans();
		vidaAbsorbida -= 4;
		return new CellSemiPerfecto(estado, vidaAbsorbida);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(5);
		Ataque ataque = new AtaqueBasico(estado.getPoderDePelea(poderDePelea));
		estado.incrementarVida(ataque.getDano());
		vidaAbsorbida++;
		enemigo.recibirAtaque(ataque);
	}
}
