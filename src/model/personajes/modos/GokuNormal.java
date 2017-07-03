package model.personajes.modos;

import model.Unidad;
import model.ataque.Kamehameha;
import model.atributos_de_unidad.Estado;
import model.atributos_de_unidad.Modo;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public class GokuNormal extends Modo {
	
    public GokuNormal() {
    	nombre            = "Goku";
    	velocidad         = 2;
    	distanciaDeAtaque = 2;
    	poderDePelea      = 20;
    	
    	estado = new Estado(500);
    }

    @Override
    public int getPoderDePelea() throws ErrorUnidadParalizada {
    	if (estado.getVida().getPorcentajeVida() < 30)
    		return estado.getPoderDePelea((int)(poderDePelea * 1.2));
    	return super.getPoderDePelea();
    }
    
	@Override
	public Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		try {
			estado.reducirKi(20);
		}
		catch (ErrorKiInsuficiente e) { 
			throw new ErrorNoCumpleReqTrans();
		}
		
		return new GokuKaioKen(estado);
	}

	@Override
	public void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada {
		estado.reducirKi(20);
		enemigo.recibirAtaque(new Kamehameha(getPoderDePelea()));
	}


}
