package model.efectos;

import model.error.ErrorUnidadParalizada;

public class Paralizante extends Efecto {

	public Paralizante(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public int getBoostDistanciaDeAtaque(int distanciaDeAtaqueBase) throws ErrorUnidadParalizada {
		throw new ErrorUnidadParalizada();
	}

	@Override
	public int getBoostVelocidad(int velocidadBase) throws ErrorUnidadParalizada {
		throw new ErrorUnidadParalizada();
	}

	@Override
	public int getBoostPoderDePelea(int poderDePeleaBase) throws ErrorUnidadParalizada {
		throw new ErrorUnidadParalizada();
	}

	@Override
	public int getBoostDeKi() throws ErrorUnidadParalizada {
		throw new ErrorUnidadParalizada();
	}
	
	@Override
	public boolean paraliza() {
		return true;
	}

}
