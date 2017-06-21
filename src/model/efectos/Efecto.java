package model.efectos;

public abstract class Efecto {
	int duracion;
	public Efecto(int duracion){
		this.duracion = duracion;
	}

	
	public int tiempoRestante(){
		return duracion;
	}
	public void pasarTurno(){
		duracion--;
	}
	
	public abstract int getBoostAtaque();
	public abstract int getBoostVelocidad();
	public abstract boolean paraliza();
	
}
