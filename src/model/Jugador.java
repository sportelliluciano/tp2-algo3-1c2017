package model;
import java.util.List;

import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.error.ErrorYaAtaco;
import model.error.ErrorYaMovio;

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
			throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorYaMovio {
		if (!equipo.pertenece(personaje))
			throw new RuntimeException();
		if (movio)
			throw new ErrorYaMovio();

		juego.getTablero().moverUnidad(personaje, posicionNueva);
		movio = true;
	}
	
	public void ataqueBasico(Unidad personaje, Unidad enemigo) 
			throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorYaAtaco {
		if ((!equipo.pertenece(personaje)) || (equipo.pertenece(enemigo)))
			throw new ErrorUnidadNoEsEnemiga();
		if (ataco)
			throw new ErrorYaAtaco();

		personaje.ataqueBasicoA(enemigo, juego.getTablero());
		if (!enemigo.getVida().estaVivo())
			juego.getTablero().eliminarPosicionable(enemigo.getPosicion());
		ataco = true;
	}
	
	public void ataqueEspecial(Unidad personaje, Unidad enemigo) 
			throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida, ErrorKiInsuficiente, ErrorUnidadParalizada, ErrorYaAtaco {
		if ((!equipo.pertenece(personaje)) || (equipo.pertenece(enemigo)))
			throw new RuntimeException();
		if (ataco)
			throw new ErrorYaAtaco();
		
		personaje.ataqueEspecialA(enemigo, juego.getTablero());
		if (!enemigo.getVida().estaVivo())
			juego.getTablero().eliminarPosicionable(enemigo.getPosicion());
		ataco = true;
	}
	
	public void pasarTurno() {
		movio = ataco = false;
		equipo.pasarTurno();
	}
}

