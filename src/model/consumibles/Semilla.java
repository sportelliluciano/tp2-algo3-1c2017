package model.consumibles;

import model.Consumible;

public class Semilla extends Consumible {
	@Override
	public int vidaIncrementada() {
		return 100;
	}
}
