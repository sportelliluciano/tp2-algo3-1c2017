package model.atributos_de_unidad.modos;

import model.Unidad;
import model.atributos_de_unidad.Modo;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public class GohanNormal extends Modo {

	private int velocidad = 2;
	private int ataqueBasico = 15;//Nuevo
    private int distanciaDeAtaque = 2;//Nuevo

	@Override
	public boolean puedeTransformarse(Unidad u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombre() {
		return "Normal";
	}

	@Override
	public int getVelocidad() {
		return velocidad;
	}
	
	@Override
	public int getAtaqueBasico(){//Nuevo
		return ataqueBasico ;
	}
	
	@Override
	public int getDistanciaDeAtaque(){//Nuevo
	    return distanciaDeAtaque;
	}
}
