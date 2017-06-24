package model.personajes.modos;

import model.Unidad;
import model.ataque.ConvierteteEnChocolate;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class MajinBooNormal extends Modo {
	public MajinBooNormal() {
    	nombre = "Majin Boo Normal";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
        poderDePelea = 30;
        
        estado = new Estado(300);
    }

	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(20);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		return new MajinBooMalo(estado);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(30);
		enemigo.recibirAtaque(new ConvierteteEnChocolate());
	}
}
