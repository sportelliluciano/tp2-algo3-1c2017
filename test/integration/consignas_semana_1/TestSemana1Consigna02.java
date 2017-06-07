package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GohanNormal;
import model.atributos_de_unidad.modos.GokuNormal;

public class TestSemana1Consigna02 {
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
	}*/
	
	
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

}
