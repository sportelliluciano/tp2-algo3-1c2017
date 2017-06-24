package model.personajes.modos;

import model.Unidad;
import model.ataque.Makankosappo;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class PiccoloNormal extends Modo {

	private GuerrerosZ equipo;
	
	public PiccoloNormal(GuerrerosZ equipo) {
		nombre            = "Piccolo Normal";
    	velocidad         = 2;
    	distanciaDeAtaque = 2;
     	poderDePelea      = 20;
     	
     	estado = new Estado(500);
     	this.equipo = equipo;
	}

	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(20);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		
		return new PiccoloFortalecido(estado, equipo);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(10);
		enemigo.recibirAtaque(new Makankosappo(getPoderDePelea()));
	}
	
	protected PiccoloNormal() {
		
	}
}
