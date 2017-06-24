package model.atributos_de_unidad;

import java.util.ArrayList;

import model.ataque.Ataque;
import model.efectos.Efecto;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorUnidadParalizada;

public class Estado {
	protected ArrayList<Efecto> efectos;
	private Vida vida;
	private Ki ki;
	private int cantidadEsferas = 0;
	
	
	public Estado(int vidaMaxima) {
		efectos = new ArrayList<Efecto>();
		vida = new Vida(vidaMaxima);
		ki = new Ki();
	}
	
	public void moverseEsPosible() throws ErrorUnidadParalizada {
		if(paralizado()) throw new ErrorUnidadParalizada();
		return;
	}
	
	private void limpiarEfectosTerminados() {
		for(int i=0;i<efectos.size();i++) {
			if (efectos.get(i).tiempoRestante() <= 0) {
				efectos.remove(i);
			}
		}
	}
	
	public void pasarTurno(){
		for(Efecto efecto : efectos){
			efecto.pasarTurno();
		}
		limpiarEfectosTerminados();
		if (!paralizado())
			ki.pasarTurno();
	}
	
	public void aplicarEfectos(ArrayList<Efecto> efectos){
		for(Efecto efecto : efectos){
			this.efectos.add(efecto);
		}
	}
	
	public boolean paralizado(){
		for(Efecto efecto : efectos){
			if(efecto.paraliza()) return true;
		}
		return false;
	}
	
	public int calcularBoostAtaque(){
		int boost = 0;
		for(Efecto efecto : efectos){
			boost += efecto.getBoostAtaque();
		}
		return boost;
		
	}
	public int aplicarBoost(int poderAtaqueBase){
		return poderAtaqueBase + (poderAtaqueBase*calcularBoostAtaque())/100;
		
	}
	
	public int calcularBoostVelocidad(){
        int boost = 0;
		for(Efecto efecto : efectos) {
			boost += efecto.getBoostVelocidad();
		}
		return boost;
	}
	
	
	public int aplicarBoostVelocidad(int velocidad){
		return velocidad + (velocidad*calcularBoostVelocidad())/100;
	}

	public int getVelocidad(int velocidadBase) throws ErrorUnidadParalizada {
		if (paralizado())
			throw new ErrorUnidadParalizada();
		return aplicarBoostVelocidad(velocidadBase);
	}
	
	public int getPoderDePelea(int poderDePeleaBase) throws ErrorUnidadParalizada {
		if (paralizado()) 
			throw new ErrorUnidadParalizada();
		return aplicarBoost(poderDePeleaBase);
	}
	
	public int getDistanciaDeAtaque(int distanciaDeAtaqueBase) throws ErrorUnidadParalizada {
		if (paralizado()) 
			throw new ErrorUnidadParalizada();
		return distanciaDeAtaqueBase;
	}

	public void recibirAtaque(Ataque ataque) {
		aplicarEfectos(ataque.efectos());
		vida.reducirEn(ataque.getDano());
	}

	public Ki getKi() {
		return ki;
	}
	
	public Vida getVida() {
		return vida;
	}

	public int cantidadDeEsferasDelDragon() {
		return cantidadEsferas;
	}

	public void reducirKi(int magnitud) throws ErrorKiInsuficiente {
		ki.reducirEn(magnitud);
	}

	public void incrementarVida(int magnitud) {
		vida.incrementarEn(magnitud);		
	}
}
