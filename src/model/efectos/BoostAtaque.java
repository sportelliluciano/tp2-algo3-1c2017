package model.efectos;

public class BoostAtaque extends Efecto{
	int porcentaje;
	
	public BoostAtaque(int porcentaje, int duracion){
		super(duracion);
		this.porcentaje = porcentaje;
	}

	@Override
	public int getBoostAtaque() {
		return porcentaje;
	}

	@Override
	public int getBoostVelocidad() {
		return 0;
	}

	@Override
	public boolean paraliza() {
		return false;
	}
	
}
