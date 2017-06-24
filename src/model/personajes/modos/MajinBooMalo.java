package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class MajinBooMalo extends MajinBooNormal {
	public MajinBooMalo(Estado estadoAnterior) {
    	nombre            = "Boo Malo";
    	velocidad         = 3;
    	distanciaDeAtaque = 2;
        poderDePelea      = 50;
        
        estado = estadoAnterior;
    }
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(50);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		return new MajinBooOriginal(estado);
	}
}
