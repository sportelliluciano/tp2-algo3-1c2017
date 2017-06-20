package model.atributos_de_unidad;

import model.ataque.Ataque;

public class Estado {
	public int duracionParalisis;
	public	int envenenamiento;
	public int silencio;
	public int reduccionVelocidad;
	
	public Estado(){
		this.duracionParalisis = 0;
	}
	
	public boolean moverseEsPosible() {
		return !paralizado();
	}
	
	public void paralizar(int porCantidadDeTurnos){
		duracionParalisis = porCantidadDeTurnos;
	}
	public void pasarTurno(){
		if(duracionParalisis!=0) duracionParalisis--;
	}

	public void recibirAtaque(Ataque ataque) {
		paralizar(ataque.paralizaDurante());
		
	}
	
	public boolean paralizado(){
		return duracionParalisis!=0;
	}
}
