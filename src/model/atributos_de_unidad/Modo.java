package model.atributos_de_unidad;

import model.Unidad;

// El enunciado a veces le dice "modo" a la "transformacion actual" o falta de ella.
public abstract class Modo {
	
	public abstract boolean puedeTransformarse(Unidad u);
	
	public abstract Modo transformarA(Unidad u);
	
}
