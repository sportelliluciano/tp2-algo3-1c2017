package model;

import java.util.HashSet;

import model.atributos_de_unidad.*;
import model.error.ErrorNoCumpleReqTrans;

// Uno de los 3 tipitos que maneja el jugador.
public class Unidad extends Posicionable {

	private Modo modo;
	private Ki ki = new Ki();
	
	public Unidad(Modo modo) {
		this.modo = modo;
	}

	public HashSet<Posicion> movsPosibles(Tablero tablero) {
		
		HashSet<Posicion> posiciones = new HashSet<Posicion>();
		//_movsPosibles(tablero, posiciones, getPosicion(), modo.getVelocidad());
		return posiciones;
	}
	
	/*private void _movsPosibles(Tablero tablero, HashSet<Posicion> posiciones, Posicion posicion, int movRestantes) {

		if (movRestantes == 0)
			return;
		
		for (Posicion p: posicion.getVecinos()) {
			
			if (puedeMoverseA(p, tablero) && !posiciones.contains(p)){
				posiciones.add(p);
				_movsPosibles(tablero, posiciones, p, movRestantes - 1);
			}
		}
	}*/

	/*private boolean puedeMoverseA(Posicion p, Tablero tablero) { // No se si esto de enchufar el tablero aca servira pero x ahora...
		return true;
	}*/

	public void moverA(Posicion nuevaPosicion) {
		setPosicion(nuevaPosicion);
	}

	public void ocuparLugarDe(Posicionable p) {
		Posicion nuevaPosicion = p.getPosicion();
		p.serOcupadoPor(this);
		moverA(nuevaPosicion);
	}
	
	@Override
	public void serOcupadoPor(Unidad u) {
		throw new RuntimeException();
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
