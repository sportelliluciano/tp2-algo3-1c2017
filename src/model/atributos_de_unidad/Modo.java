package model.atributos_de_unidad;

import model.Unidad;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;

// El enunciado a veces le dice "modo" a la "transformacion actual" o falta de ella.
public abstract class Modo {
	
	public abstract boolean puedeTransformarse(Unidad u);
	
	public abstract Modo transformarA(Unidad u) throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans;
	
	public abstract String getNombre();

	public abstract int getVelocidad();
	
	//	public abstract int getDistanciaDeAtaque();

}
