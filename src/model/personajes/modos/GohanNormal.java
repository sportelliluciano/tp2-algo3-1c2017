package model.personajes.modos;

import model.Unidad;
import model.ataque.Masenko;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class GohanNormal extends Modo {

	protected GuerrerosZ equipo;
	
	public GohanNormal(GuerrerosZ equipo) {
    	nombre            = "Gohan Normal";
    	velocidad         = 2;
    	distanciaDeAtaque = 2;
     	poderDePelea      = 15;
     	
     	this.equipo       = equipo;
        estado            = new Estado(300);
    }

	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(10);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		
		return new GohanSSJFase1(estado, equipo);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(10);
		enemigo.recibirAtaque(new Masenko(getPoderDePelea()));
	}
    
	protected GohanNormal() {
		
	}
}
