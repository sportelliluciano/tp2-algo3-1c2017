package model.efectos;

import model.error.ErrorUnidadParalizada;

public class EfectoNubeVoladora extends Efecto {
	private int multiplicadorVelocidad;
	
	public EfectoNubeVoladora() {
		this.multiplicadorVelocidad = 1;
		this.duracion = 2;
	}

	@Override
	public int getBoostVelocidad(int velocidadBase) throws ErrorUnidadParalizada {
		return velocidadBase * multiplicadorVelocidad;
	}

}
