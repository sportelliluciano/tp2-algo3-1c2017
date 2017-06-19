package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Ki;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.personajes.Gohan;

public class PiccoloFortalecido extends Modo {

	private GuerrerosZ equipo;
	
	public PiccoloFortalecido(GuerrerosZ equipo) {
		nombre = "Piccolo Fortalecido";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = new AtaqueBasico(20);
     	
     	this.equipo = equipo;
        siguienteModo = new PiccoloProtector();
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		Gohan gohan = equipo.getGohan();
		if (gohan.getVidaActual() > gohan.getVidaMaxima() * 0.2)
			throw new ErrorNoCumpleReqTrans();
		
		return siguienteModo;
	}
	
}
