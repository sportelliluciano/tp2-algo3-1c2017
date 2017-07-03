package model.atributos_de_unidad;

import java.util.ArrayList;

import model.Consumible;
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
	
	private void limpiarEfectosTerminados() {
		for(int i=0;i<efectos.size();i++) {
			if (efectos.get(i).tiempoRestante() <= 0) {
				efectos.remove(i);
			}
		}
	}
	
	public void pasarTurno() {
		for(Efecto efecto : efectos)
			efecto.pasarTurno();
		limpiarEfectosTerminados();
		if (!paralizado())
			ki.pasarTurno();
	}
	
	public void aplicarEfectos(ArrayList<Efecto> efectos){
		for(Efecto efecto : efectos)
			this.efectos.add(efecto);
	}
	
	public void consumir(Consumible consumible) {
		vida.incrementarEn(consumible.getIncrementoVida());
		cantidadEsferas += consumible.getCantidadEsferasDelDragon();
		aplicarEfectos(consumible.getEfectos());
	}
	
	public int getVelocidad(int velocidadBase) throws ErrorUnidadParalizada {
		int velocidadExtra = 0;
		for (Efecto efecto : efectos)
			velocidadExtra += efecto.getBoostVelocidad(velocidadBase);
		return velocidadBase + velocidadExtra;
	}
	
	public int getPoderDePelea(int poderDePeleaBase) throws ErrorUnidadParalizada {
		int poderDePeleaExtra = 0;
		for (Efecto efecto : efectos)
			poderDePeleaExtra += efecto.getBoostPoderDePelea(poderDePeleaBase);
		return poderDePeleaBase + poderDePeleaExtra;
	}
	
	public int getDistanciaDeAtaque(int distanciaDeAtaqueBase) throws ErrorUnidadParalizada {
		int distanciaDeAtaqueExtra = 0;
		for (Efecto efecto : efectos)
			distanciaDeAtaqueExtra += efecto.getBoostDistanciaDeAtaque(distanciaDeAtaqueBase);
		return distanciaDeAtaqueBase + distanciaDeAtaqueExtra;
	}

	public void recibirAtaque(Ataque ataque, int poderDePeleaBase) {
		aplicarEfectos(ataque.efectos());
		vida.reducirEn(ataque.getDano(poderDePeleaBase));
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
	
	public boolean paralizado() {
		for (Efecto efecto : efectos) {
			if (efecto.paraliza())
				return true;
		}
		return false;
	}
}
