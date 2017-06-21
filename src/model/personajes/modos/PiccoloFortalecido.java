package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.Makankosappo;
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
    	velocidad = 3;
    	distanciaDeAtaque = 4;
     	ataqueBasico = new AtaqueBasico(40);
     	ataqueEspecial = new Makankosappo(40);
     	poderDeAtaque = 40;
     	
     	this.equipo = equipo;
        siguienteModo = new PiccoloProtector();
	}
	
	@Override
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		Gohan gohan = equipo.getGohan();
		if (gohan.getPorcentajeVida() > 20)
			throw new ErrorNoCumpleReqTrans();
		
		return siguienteModo;
	}
	
}
