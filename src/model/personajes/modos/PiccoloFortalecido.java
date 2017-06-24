package model.personajes.modos;

import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.personajes.Gohan;

public class PiccoloFortalecido extends PiccoloNormal {

	private GuerrerosZ equipo;
	
	public PiccoloFortalecido(Estado estadoAnterior, GuerrerosZ equipo) {
		nombre            = "Piccolo Fortalecido";
    	velocidad         = 3;
    	distanciaDeAtaque = 4;
     	poderDePelea      = 40;
     	
     	estado = estadoAnterior;
     	this.equipo = equipo;
	}
	
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		Gohan gohan = equipo.getGohan();
		if (gohan.getVida().getPorcentajeVida() > 20)
			throw new ErrorNoCumpleReqTrans();
		
		return new PiccoloProtector(estado);
	}
	
}
