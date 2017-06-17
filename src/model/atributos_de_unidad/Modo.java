package model.atributos_de_unidad;

import model.Unidad;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public abstract class Modo {
	
	protected Modo siguienteModo;
	protected String nombre;
	protected int velocidad;
	protected int ataqueBasico;
	protected int distanciaDeAtaque;
	
	public abstract boolean puedeTransformarse(Unidad u);
	
	public abstract Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans;
	
	public String getNombre() {
		return nombre;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public int getAtaqueBasico() {
		return ataqueBasico;
	}
	
	public int getDistanciaDeAtaque() {
		return distanciaDeAtaque;
	}

}
