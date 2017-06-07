package integration;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GokuNormal;

public class TestFirstWeek {
	
	@Test
	public void test01MoverUnidadCambiaSuPosicion(){
		// TODO: Implement
				
		Tablero tablero = new Tablero();
		Posicion pos_vieja = new Posicion(5,5);
		Posicion pos_nueva = new Posicion(6,5);
		Unidad goku = new Unidad(new GokuNormal(), pos_vieja);
		tablero.agregar(goku);
		
		tablero.moverUnidad(goku, pos_nueva);
		assertTrue(goku.getPosicion().equals(pos_nueva));
		
	}
	
	@Test
	public void test02aCrearUnidadEnPosicionTomadaLanzaExcepcion() {
		// TODO: Implement
		
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku.
		// Crear un gohan, seteando su posicion (x,y) a la misma de goku
		// O bien hacemos que explote y capturamos la excepcion..
		// o bien, que no cree al gohan y confirmar (por tablero o juego) que solo goku existe.
		
		assertTrue(false);
	}
	
	@Test
	public void test02NoSePuedeMoverUnidadAPosicionTomadaPorOtraUnidad() {
		// TODO: Implement
	
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku
		// Crear un gohan del mismo bando, ubicado bien cerquita de goku
		// Tratar de mover a gohan a la posicion de goku.
		// O bien tirar excepcion ahi y esperarla con el test, o tener una funcion de "puede moverse ahi" q de false.

		assertTrue(false);
	}

	@Test
	public void test03aNoSePuedeAtravesarUnidadAmistosa() {
		// TODO: Implement
	
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku
		// Crear un gohan del mismo bando, ubicado bien cerquita de goku
		// Tratar de mover a gohan 2 lugares abajo y 2 a la izquierda (lo que haria q tuviera que pasar encima de goku)
		// O bien tirar excepcion ahi y esperarla con el test, o tener una funcion de "puede moverse ahi" q de false.

		assertTrue(false);
	}
	
	@Test
	public void test03bNoSePuedeAtravesarUnidadEnemiga() {
		// TODO: Implement
	
		// Lo mismo que la anterior pero con un Freezer del oponente en vez de Gohan

		assertTrue(false);
	}
	
	@Test
	public void test04TransformarseCambiaElModo() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test05MoverPersonajeTrasLaTransformacionAumentaDistancia() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test06CrearJuegoYValidarPosicionesDeTablero() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test07NoSePuedeAtacarEnemigosMuyLejos() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test07AtacarEnemigoCercanoReduceSuVida() {
		// TODO: Implement
		assertTrue(false);
	}
	
}
