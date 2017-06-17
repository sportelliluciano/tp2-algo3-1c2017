package model;

import java.util.HashSet;
import java.util.Set;

import model.ataque.Ataque;
import model.atributos_de_unidad.*;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;

public abstract class Unidad extends Posicionable {

	protected Modo modo;
	protected Ki ki = new Ki();
	protected int vidaMaxima;
	protected int vidaActual;

	public Set<Posicion> movsPosibles(Tablero tablero) throws ErrorPosicionInvalida {
		Set<Posicion> posiciones = new HashSet<Posicion>();
		_movsPosibles(tablero, posiciones, getPosicion(), modo.getVelocidad());
		return posiciones;
	}
	
	private void _movsPosibles(Tablero tablero, Set<Posicion> posiciones, Posicion posicion, int movRestantes) throws ErrorPosicionInvalida {

		if (movRestantes == 0)
			return;
		
		for (Posicion p: posicion.getVecinos(Direccion.getDireccionesSinDiagonales())) {
			
			if (!tablero.hayPosicionableEn(p)){
				posiciones.add(p);
				_movsPosibles(tablero, posiciones, p, movRestantes - 1);
			}
		}
	}
	
	public void moverA(Posicion nuevaPosicion, Tablero tablero) throws ErrorPosicionInvalida {
		Set<Posicion> movimientos = movsPosibles(tablero);
		if (!movimientos.contains(nuevaPosicion))
			throw new ErrorPosicionInvalida();
		setPosicion(nuevaPosicion);
	}

	public void pasarTurno() {
		ki.pasarTurno();
	}
	
	public void transformarse() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		this.modo = this.modo.siguienteTransformacion(this.ki); 
	}
	
	public Modo getModo() {
		return this.modo;
	}
	
	public Ki getKi() {
		return this.ki;
	}
	
	public void ataqueBasicoA(Unidad unidad) {
		unidad.recibirAtaque(modo.getAtaqueBasico());
	}
	
	public void ataqueEspecialA(Unidad unidad) throws ErrorKiInsuficiente {
		unidad.recibirAtaque(modo.getAtaqueEspecial());
	}
	
	public void recibirAtaque(Ataque ataque) {
		vidaActual -= ataque.getDano();
	}
	
	public boolean estaVivo() {
		return this.vidaActual > 0;
	}
	
	public int getVidaActual() {
		return this.vidaActual;
	}
	
/*
//solo correr los test y no tener que modificar el cosntructor
	public int getVida(){
		return vida;
	}

	public void setVida(int puntosDeVida) {
		vida = puntosDeVida;
	}
	//no se si esta bien ubicado en esta clase,pero anda
	public void atacarBasicoA(Unidad enemigo) throws ErrorEnemigoFueraDeAlcance{ 
		if(!enemigoEstaDentroDeAlcance(enemigo))
			throw new ErrorEnemigoFueraDeAlcance();
		enemigo.setVida( enemigo.getVida() - modo.getAtaqueBasico() );
	}
	
	private boolean enemigoEstaDentroDeAlcance(Unidad enemigo) {
		Posicion posicionPropia = getPosicion();
		Posicion posicionEnemiga = enemigo.getPosicion();
		
		if(posicionPropia.getX() == posicionEnemiga.getX())
			if(modo.getDistanciaDeAtaque() + posicionPropia.getY() >= posicionEnemiga.getY() )
				return true;
	
		if(posicionPropia.getY() == posicionEnemiga.getY())
			if(modo.getDistanciaDeAtaque() + posicionPropia.getX() >= posicionEnemiga.getX() )
				return true;
		
		if( Math.abs(posicionPropia.getX() - posicionEnemiga.getX()) == Math.abs(posicionPropia.getY() - posicionEnemiga.getY()) )
			if(modo.getDistanciaDeAtaque() >= Math.abs(posicionPropia.getX() - posicionEnemiga.getX()) )
				return true;
	
		return false;
	}*/
}
