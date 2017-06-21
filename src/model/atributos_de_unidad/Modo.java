package model.atributos_de_unidad;

import model.ataque.Ataque;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public abstract class Modo {
	
	protected Modo siguienteModo;
	protected String nombre;
	protected int velocidad;
	protected Ataque ataqueBasico;
	protected Ataque ataqueEspecial;
	protected int distanciaDeAtaque;
	protected int costoKiSiguienteTransformacion;
	protected int costoKiAtaqueEspecial;
	protected int poderDeAtaque;
	
	public Modo siguienteTransformacion(Ki ki) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		if (ki.getMagnitud() < costoKiSiguienteTransformacion)
			throw new ErrorNoCumpleReqTrans();
		return siguienteModo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public Ataque getAtaqueBasico() {
		return ataqueBasico;
	}
	
	public Ataque getAtaqueEspecial() {
		return ataqueEspecial;
	}
	
	public int getDistanciaDeAtaque() {
		return distanciaDeAtaque;
	}

	public void incrementarPoderPelea(double multiplicador) {
	}
	public int getCostoKiAtaqueEspecial(){
		return costoKiAtaqueEspecial;
	}
	
	public int getPoderDeAtaque(){
		return poderDeAtaque;
	}
}
