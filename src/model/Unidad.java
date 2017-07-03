package model;

import model.ataque.Ataque;
import model.atributos_de_unidad.*;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadNoSePuedePisar;
import model.error.ErrorUnidadParalizada;
import model.error.ErrorEnemigoFueraDeAlcance;


public abstract class Unidad extends Posicionable {

	protected Equipo equipo;
	protected Modo modo;

	public String getNombre() {
		return modo.getNombre();
	}
	
	public Ki getKi() {
		return this.modo.getKi();
	}
	
	public Vida getVida() {
		return this.modo.getVida();
	}
	
	public void pasarTurno() {
		modo.pasarTurno();
	}
	
	public void moverA(Posicion nuevaPosicion, Consumible consumible) {
		consumir(consumible);
		setPosicion(nuevaPosicion);
	}
	
	public void ataqueBasicoA(Unidad enemigo, Tablero tablero) throws ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		validarAtaque(enemigo, tablero);
	    modo.ataqueBasicoA(enemigo);
	}
	
	public void ataqueEspecialA(Unidad enemigo, Tablero tablero) throws ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		validarAtaque(enemigo, tablero);
		modo.ataqueEspecialA(enemigo);
	}
	
	public void recibirAtaque(Ataque ataque) {
		modo.recibirAtaque(ataque);
	}
	
	public void consumir(Consumible consumible) {
		modo.consumir(consumible);
	}
	
	public void transformarse() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		this.modo = this.modo.siguienteTransformacion(); 
	}
	
	public boolean estaVivo() {
		return getVida().estaVivo();
	}
	
	public int cantidadDeEsferasDelDragon() {
		return modo.cantidadDeEsferasDelDragon();
	}
		
	protected void validarAtaque (Unidad enemigo, Tablero tablero) throws ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
	    if(!tablero.estaDentroDelAlcance(getPosicion(),enemigo.getPosicion(), modo.getDistanciaDeAtaque()))
			throw new ErrorEnemigoFueraDeAlcance();
	    if(equipo.pertenece(enemigo))
	    	throw new ErrorUnidadNoEsEnemiga(); 
	}

	public int getVelocidad() throws ErrorUnidadParalizada {
		return modo.getVelocidad();
	}

	public boolean estaParalizado() {
		return modo.estaParalizado();
	}
	
	public Consumible pisar() throws ErrorUnidadNoSePuedePisar {
		throw new ErrorUnidadNoSePuedePisar();
	}

	public int getDistanciaDeAtaque() throws ErrorUnidadParalizada {
		return modo.getDistanciaDeAtaque();
	}
}
