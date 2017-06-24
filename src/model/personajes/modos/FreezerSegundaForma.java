package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class FreezerSegundaForma extends FreezerNormal {
	public FreezerSegundaForma(Estado estadoAnterior) {
    	nombre            = "Freezer Segunda Forma";
    	velocidad         = 4;
    	distanciaDeAtaque = 3;
    	poderDePelea      = 40;
    	
        estado = estadoAnterior;
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(50);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		return new FreezerDefinitivo(estado);
	}
}
