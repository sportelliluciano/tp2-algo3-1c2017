package model.efectos;

public class BoostVelocidad extends Efecto {
	int boost;
	
	public BoostVelocidad(int duracion, int boost) {
		super(duracion);
		this.boost = boost;
	}

	@Override
	public int getBoostAtaque() {
		return 0;
	}

	@Override
	public int getBoostVelocidad() {
		return boost;
	}

	@Override
	public boolean paraliza() {
		// TODO Auto-generated method stub
		return false;
	}

}
