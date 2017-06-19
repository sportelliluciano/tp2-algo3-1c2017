package model;

import java.util.List;

public abstract class Equipo {
	protected List<Unidad> integrantes;
	
	public int cantidadDeEsferasDelDragon() {
		int total = 0;
		for (Unidad u : integrantes)
			total += u.cantidadDeEsferasDelDragon();
		return total;
	}

	public boolean pertenece(Unidad unidad) {
		for (Unidad integrante : integrantes) {
			if (integrante == unidad)
				return true;
		}
		
		return false;			
	}
}
