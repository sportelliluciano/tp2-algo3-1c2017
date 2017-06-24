package model.efectos;

import model.error.ErrorUnidadParalizada;

public abstract class Efecto {
	protected int duracion;
	
	public int getBoostDistanciaDeAtaque(int distanciaDeAtaqueBase) throws ErrorUnidadParalizada {
		return 0;
	}
	
	public int getBoostVelocidad(int velocidadBase) throws ErrorUnidadParalizada {
		return 0;
	}
	
	public int getBoostPoderDePelea(int poderDePeleaBase) throws ErrorUnidadParalizada {
		return 0;
	}
	
	public int getBoostDeKi() throws ErrorUnidadParalizada {
		return 0;
	}
	
	public int getBoostDeVida() throws ErrorUnidadParalizada {
		return 0;
	}
	
	public boolean paraliza() { // [Lucho]: Esto para mi hay que ver como eliminarlo.
		return false;
	}
	
	public void pasarTurno() {
		if (duracion > 0)
			duracion--;
	}
	
	public int tiempoRestante() {
		return duracion;
	}
}
