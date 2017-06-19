package model;

import java.util.HashSet;
import java.util.Set;

import model.ataque.Ataque;
import model.atributos_de_unidad.*;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorEnemigoFueraDeAlcance;


public abstract class Unidad extends Posicionable {

	protected Equipo equipo;
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
	
	public void ataqueBasicoA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
	    validarAtaque(unidad, tablero);
	    Ataque ataqueBasico = modo.getAtaqueBasico();
		unidad.recibirAtaque(ataqueBasico);
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
	    validarAtaque(unidad,tablero);
	    Ataque ataqueEspecial = modo.getAtaqueEspecial();
		unidad.recibirAtaque(ataqueEspecial);
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
	
	public int getVidaMaxima() {
		return this.vidaMaxima;
	}
		
	private void validarAtaque (Unidad enemigo, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
	    if(!enemigoEstaDentroDeAlcance(enemigo,tablero))
			throw new ErrorEnemigoFueraDeAlcance();
	    if(equipo.pertenece(enemigo))
	    	throw new ErrorUnidadNoEsEnemiga(); 
	}
	
	private boolean enemigoEstaDentroDeAlcance(Unidad enemigo,Tablero tablero) throws ErrorPosicionInvalida {
		Posicion posEnemiga = enemigo.getPosicion();
		
		Set<Posicion> posPosibles = this.posicionesPosibles(tablero);
		if(posPosibles.contains(posEnemiga))
			return true;
		
		return false;
		
	}
	
	//este metodo busca cuales son las posiciones que llega el ataque.FALTA A�ADIR SI TRASPASA O NO A UNIDAD ALIADA
	private Set<Posicion> posicionesPosibles(Tablero tablero) throws ErrorPosicionInvalida {
		
		Set<Posicion> posiciones = new HashSet<Posicion>();
		
		for (Direccion d: Direccion.getDireccionesConDiagonales()) 
			_posicionesPosibles(tablero, d, posiciones,d.obtenerPosicionNueva(getPosicion()), modo.getDistanciaDeAtaque());
		
		return posiciones;
	}
	
	private void _posicionesPosibles(Tablero tablero, Direccion d,Set<Posicion> posiciones,Posicion p, int distanciaRestante) throws ErrorPosicionInvalida {
	    if (distanciaRestante == 0)
		    return;	
	
	    try{
	        tablero.validarPosicion(p);}//para que cuando choque al tablero no se pase    
        catch(Exception ErrorPosicionInvalida){
    	    return;}
	
	    posiciones.add(p);

        if(tablero.hayPosicionableEn(p)) return;//si se encontro una unidad la deja guarda y sale
    
	    p = d.obtenerPosicionNueva(p);
 	    _posicionesPosibles(tablero,d, posiciones, p, distanciaRestante - 1);
	
    }

	public int cantidadDeEsferasDelDragon() {
		return 0;
	}
}
