package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GokuKaioKen extends GokuNormal {

	public GokuKaioKen(Estado estadoAnterior) {
		nombre            = "Kaio-ken";	
		velocidad         = 3;
		distanciaDeAtaque = 4;
		poderDePelea      = 40;
		
		estado            = estadoAnterior;
	}
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(50);
		}
		catch (ErrorKiInsuficiente e) { 
			throw new ErrorNoCumpleReqTrans();
		}
		
		return new GokuSSJ(estado);
	}
	
}