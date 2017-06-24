package model.personajes.modos;

import model.Unidad;
import model.ataque.RayoMortal;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class FreezerNormal extends Modo {
	
    public FreezerNormal() {
    	nombre            = "Freezer Normal";
    	velocidad         = 4;
    	distanciaDeAtaque = 2;
        poderDePelea      = 20;
        
        estado = new Estado(400);
    }

    @Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(20);
		} catch (ErrorKiInsuficiente e) {
			throw new ErrorNoCumpleReqTrans();
		}
		return new FreezerSegundaForma(estado);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(20);
		enemigo.recibirAtaque(new RayoMortal(getPoderDePelea()));
	}
    
}