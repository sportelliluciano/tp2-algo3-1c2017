package model;

import java.util.List;

public abstract class Equipo {
	protected List<Unidad> integrantes;
	protected String nombreEquipo;
	
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
	
	public List<Unidad> integrantes() {
		return integrantes;
	}

	public void pasarTurno() {
		for(Unidad integrante : integrantes)
			integrante.pasarTurno();
	}

	public boolean estaVivo() {
		for (Unidad integrante : integrantes) {
			if (integrante.estaVivo())
				return true;
		}
		return false;
	}

	public String getNombre() {
		return nombreEquipo;
	}
}
