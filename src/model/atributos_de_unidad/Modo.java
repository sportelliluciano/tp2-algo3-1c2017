package model.atributos_de_unidad;

import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

public abstract class Modo {
	
	protected Modo siguienteModo;
	protected String nombre;
	protected int velocidad;
	protected int ataqueBasico;
	protected int distanciaDeAtaque;
	protected int costoKiSiguienteTransformacion;
	
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
	
	public int getAtaqueBasico() {
		return ataqueBasico;
	}
	
	public int getDistanciaDeAtaque() {
		return distanciaDeAtaque;
	}

}
