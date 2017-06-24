package model.atributos_de_unidad;

import model.Consumible;
import model.Unidad;
import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorUnidadParalizada;

public abstract class Modo {
	
	protected Estado estado;
	protected String nombre;
	
	protected int velocidad;
	protected int distanciaDeAtaque;
	protected int poderDePelea;
	
	public abstract Modo siguienteTransformacion() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans;
	
	public String getNombre() {
		return nombre;
	}

	public int getVelocidad() throws ErrorUnidadParalizada {
		return estado.getVelocidad(velocidad);
	}
	
	public int getDistanciaDeAtaque() throws ErrorUnidadParalizada {
		return estado.getDistanciaDeAtaque(distanciaDeAtaque);
	}

	public int getPoderDePelea() throws ErrorUnidadParalizada {
		return estado.getPoderDePelea(poderDePelea);
	}

	public void pasarTurno() {
		estado.pasarTurno();		
	}

	public Ki getKi() {
		return estado.getKi();
	}

	public Vida getVida() {
		return estado.getVida();
	}

	public void recibirAtaque(Ataque ataque) {
		estado.recibirAtaque(ataque);	
	}

	public void consumir(Consumible consumible) {
		estado.aplicarEfectos(consumible.efectos());
		estado.incrementarVida(consumible.vidaIncrementada());
	}

	public abstract void ataqueEspecialA(Unidad enemigo) throws ErrorKiInsuficiente, ErrorUnidadParalizada;

	public void ataqueBasicoA(Unidad enemigo) throws ErrorUnidadParalizada {
		enemigo.recibirAtaque(new AtaqueBasico(getPoderDePelea()));
	}

	public int cantidadDeEsferasDelDragon() {
		return estado.cantidadDeEsferasDelDragon();
	}

	public boolean estaParalizado() {
		return estado.paralizado();
	}
}
