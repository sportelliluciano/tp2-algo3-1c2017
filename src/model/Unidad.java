package model;

import java.util.HashSet;
import java.util.Set;

import model.atributos_de_unidad.*;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorPosicionInvalida;

// Uno de los 3 tipitos que maneja el jugador.
public class Unidad extends Posicionable {

	private Modo modo;
	private Ki ki = new Ki();
	
	
	public Unidad(Modo modo) {
		this.modo = modo;
	}

	public Set<Posicion> movsPosibles(Tablero tablero) {
		
		Set<Posicion> posiciones = new HashSet<Posicion>();
		_movsPosibles(tablero, posiciones, getPosicion(), modo.getVelocidad());
		return posiciones;
	}
	
	private void _movsPosibles(Tablero tablero, Set<Posicion> posiciones, Posicion posicion, int movRestantes) {

		if (movRestantes == 0)
			return;
		
		for (Posicion p: posicion.getVecinos()) {
			
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
	
	public void transformarse() throws ErrorNoCumpleReqTrans {
		this.modo = modo.transformarA(this);
	}

	public Modo getModo() {
		return this.modo;
	}
	
	public Ki getKi() {
		return this.ki;
	}
}
