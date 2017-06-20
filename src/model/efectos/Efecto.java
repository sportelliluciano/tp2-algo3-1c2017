package model.efectos;

public interface Efecto {
	public int tiempoRestante();
	public int getBoostAtaque();
	public int getBoostVelocidad();
	public boolean paraliza();
	public void pasarTurno();
}
