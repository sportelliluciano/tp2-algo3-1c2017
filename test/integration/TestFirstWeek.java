package integration;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GohanNormal;
import model.atributos_de_unidad.modos.GokuNormal;

public class TestFirstWeek {
	
	@Test
	public void test01MoverUnidadCambiaSuPosicion(){
				
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		tablero.moverUnidad(goku, new Posicion(6,5));
		assertTrue(goku.getPosicion().equals(new Posicion(6,5)));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void test02aCrearUnidadEnPosicionTomadaLanzaExcepcion() {
		
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(5,5));
	}
	
	/*
	@Test
	public void test02aCrearUnidadEnPosicionTomadaLanzaExcepcion() {
		// TODO: Implement
		
		Tablero tablero = new Tablero();
		Posicion pos = new Posicion(5,5);
        Unidad goku = new Unidad(new GokuNormal(), pos);
		
		try{Unidad gohan = new Unidad (new GohanNormal(),pos);
		}cath(PosicionOcudaExeption ex){
		//aca deberia poder dar a elejir otra pos para este personaje
		System.out.println("Error :" + ex.getMensaje);
		}
		// Crear un gohan, seteando su posicion (x,y) a la misma de goku
		// O bien hacemos que explote y capturamos la excepcion..
		// o bien, que no cree al gohan y confirmar (por tablero o juego) que solo goku existe.
		
		//assertTrue(false);
	}/*
	
	
	@Test
	public void test02bCrearOtraUnidadEnPosicionVacia() {
		
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(6,5));
		
		assertTrue(goku.getPosicion().equals(new Posicion(5,5)));
		assertTrue(gohan.getPosicion().equals(new Posicion(6,5)));
	}
	
	
	@Test(expected = RuntimeException.class)
	public void test02cNoSePuedeMoverUnidadAPosicionTomadaPorOtraUnidad() {
	
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(6,5));
		
		tablero.moverUnidad(gohan, new Posicion(5,5));

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
	/*
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
	*/
}
