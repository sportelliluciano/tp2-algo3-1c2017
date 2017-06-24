package model.efectos;

import model.error.ErrorUnidadParalizada;

public class EfectoEsferaDelDragon extends Efecto {

	private int duracionEnAtaques;
	private double multiplicadorPoderDePelea;

	public EfectoEsferaDelDragon() {
		duracionEnAtaques = 2;
		multiplicadorPoderDePelea = 0.25;
	}

	@Override
	public void pasarTurno() {
		return;
	}

	@Override
	public int getBoostPoderDePelea(int poderDePeleaBase) throws ErrorUnidadParalizada {
		duracionEnAtaques--;
		return (int)(poderDePeleaBase * multiplicadorPoderDePelea);
	}

	@Override
	public int tiempoRestante() {
		return duracionEnAtaques;
	}

}
