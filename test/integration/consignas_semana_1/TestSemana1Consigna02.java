package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GohanNormal;
import model.atributos_de_unidad.modos.GokuNormal;

import model.error.*;

public class TestSemana1Consigna02 {
	@Test(expected = RuntimeException.class)
	public void test02aCrearUnidadEnPosicionTomadaLanzaExcepcion() throws ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(5,5));
	}	
	
	@Test
	public void test02bCrearOtraUnidadEnPosicionVacia() throws ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(6,5));
		
		assertTrue(goku.getPosicion().equals(new Posicion(5,5)));
		assertTrue(gohan.getPosicion().equals(new Posicion(6,5)));
	}
	
	
	@Test(expected = RuntimeException.class)
	public void test02cNoSePuedeMoverUnidadAPosicionTomadaPorOtraUnidad() throws ErrorPosicionInvalida {
	
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		tablero.agregarUnidad(gohan, new Posicion(6,5));
		
		tablero.moverUnidad(gohan, new Posicion(5,5));

}

}
