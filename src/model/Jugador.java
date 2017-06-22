package model;
import java.util.List;

import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;

public class Jugador {
		
	private String nombre;
	private Equipo equipo;
	private Juego juego;
	private boolean movio, ataco;

	public Jugador(String nombre, Equipo equipo) {
		this.nombre = nombre;
		this.equipo = equipo; 
		movio = ataco = false;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Unidad> getPersonajes() {
		return equipo.integrantes();
	}

	public Equipo equipo() {
		return equipo;
	}
	
	public void mover(Unidad personaje, Posicion posicionNueva) 
			throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		if (!equipo.pertenece(personaje))
			throw new RuntimeException();
		if (movio)
			throw new RuntimeException();
		movio = true;
		personaje.moverA(posicionNueva, juego.getTablero());
	}
	
	public void ataqueBasico(Unidad personaje, Unidad enemigo) 
			throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		if ((!equipo.pertenece(personaje)) || (equipo.pertenece(enemigo)))
			throw new RuntimeException();
		if (ataco)
			throw new RuntimeException();
		ataco = true;
		personaje.ataqueBasicoA(enemigo, juego.getTablero());
	}
	
	public void ataqueEspecial(Unidad personaje, Unidad enemigo) 
			throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida, ErrorKiInsuficiente {
		if ((!equipo.pertenece(personaje)) || (equipo.pertenece(enemigo)))
			throw new RuntimeException();
		if (ataco)
			throw new RuntimeException();
		ataco = true;
		personaje.ataqueEspecialA(enemigo, juego.getTablero());
	}
	
	public void pasarTurno() {
		movio = ataco = false;
	}
}

