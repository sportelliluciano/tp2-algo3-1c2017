package model.atributos_de_unidad;

import model.ataque.Ataque;
import model.error.ErrorUnidadParalizada;

public class Estado {
	public int duracionParalisis;
	public	int envenenamiento;
	public int silencio;
	public int reduccionVelocidad;
	public int boost;
	
	public Estado(){
		this.duracionParalisis = 0;
	}
	
	public void moverseEsPosible() throws ErrorUnidadParalizada {
		if(paralizado()) throw new ErrorUnidadParalizada();
		return;
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
