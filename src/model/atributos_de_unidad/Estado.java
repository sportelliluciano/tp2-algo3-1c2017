package model.atributos_de_unidad;

import java.util.ArrayList;

import model.ataque.Ataque;
import model.efectos.Efecto;
import model.efectos.Paralizante;
import model.error.ErrorUnidadParalizada;

public class Estado {
	public ArrayList<Efecto> efectos;
	
	public Estado(){
		this.efectos = new ArrayList<Efecto>(); 
	}
	
	public void moverseEsPosible() throws ErrorUnidadParalizada {
		if(paralizado()) throw new ErrorUnidadParalizada();
		return;
	}
	
	public void pasarTurno(){
		for(Efecto efecto : efectos){
			efecto.pasarTurno();
			if(efecto.tiempoRestante()<=0) efectos.remove(efecto);
		}
	}

	public void recibirAtaque(Ataque ataque) {
		for(Efecto efecto : ataque.efectos()){
			efectos.add(efecto);
		}
	}
	
	public boolean paralizado(){
		for(Efecto efecto : efectos){
			if(efecto.paraliza()) return true;
		}
		return false;
	}
}
