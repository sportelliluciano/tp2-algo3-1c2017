package model.atributos_de_unidad;

public class Estado {
	public int duracionParalisis;
	public	int envenenamiento;
	public int silencio;
	public int reduccionVelocidad;
	
	public Estado(){
		this.duracionParalisis = 0;
	}
	
	public boolean moverseEsPosible() {
		return duracionParalisis==0;
	}
	
	public void paralizar(int porCantidadDeTurnos){
		duracionParalisis = porCantidadDeTurnos;
	}
	public void pasarTurno(){
		if(duracionParalisis!=0) duracionParalisis--;
	}
}
