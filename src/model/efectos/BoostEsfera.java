package model.efectos;

public class BoostEsfera extends Efecto {

	public BoostEsfera() {
		super(2); // Se genera un efecto de duracion 2
	}

	@Override
	public int getBoostAtaque() {
		duracion--;
		return 25;
	}

	@Override
	public int getBoostVelocidad() {
		return 0;
	}

	@Override
	public boolean paraliza() {
		return false;
	}
	public void pasarTurno(){
		return;
	}

}
