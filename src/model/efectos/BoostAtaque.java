package model.efectos;

public class BoostAtaque implements Efecto{
	int duracion;
	int porcentaje;
	
	public BoostAtaque(int porcentaje, int duracion){
		this.duracion = duracion;
		this.porcentaje = porcentaje;
	}
	
	@Override
	public int tiempoRestante() {
		return duracion;
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

	@Override
	public void pasarTurno() {
		duracion--;
	}
	
}
