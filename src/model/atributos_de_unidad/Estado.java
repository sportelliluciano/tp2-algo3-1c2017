package model.atributos_de_unidad;

import java.util.ArrayList;

import model.efectos.Efecto;
import model.error.ErrorUnidadParalizada;

public class Estado {
	protected ArrayList<Efecto> efectos;
	
	public Estado() {
		this.efectos = new ArrayList<Efecto>(); 
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
}
