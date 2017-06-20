package model.efectos;

public class Paralizante extends Efecto {

	public Paralizante(int duracion) {
		super(duracion);
	}

	@Override
	public int getBoostAtaque() {
		return 0;
	}

	@Override
	public int getBoostVelocidad() {
		return 0;
	}

	@Override
	public boolean paraliza() {
		return true;
	}

}
