package model.atributos_de_unidad;

import model.Unidad;
import model.error.ErrorNoCumpleReqTrans;

// El enunciado a veces le dice "modo" a la "transformacion actual" o falta de ella.
public abstract class Modo {
	
	public abstract boolean puedeTransformarse(Unidad u);
	
	public abstract Modo transformarA(Unidad u) throws Exception/*ErrorNoCumpleReqTrans*/;
	
	public abstract String getNombre();

	public abstract int getVelocidad();
}
