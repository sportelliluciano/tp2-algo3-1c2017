package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.error.*;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.modos.GohanNormal;
import model.personajes.modos.GokuNormal;

public class TestSemana1Consigna02 {
	@Test(expected = ErrorPosicionInvalida.class)
	public void test02aCrearUnidadEnPosicionTomadaLanzaExcepcion() throws ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		Unidad gohan = new Gohan(null);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));
		tablero.agregarPosicionable(gohan, new Posicion(5,5));
	}	
	
	@Test
	public void test02bCrearOtraUnidadEnPosicionVacia() throws ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		Unidad gohan = new Gohan(null);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));
		tablero.agregarPosicionable(gohan, new Posicion(6,5));
		
		assertTrue(goku.getPosicion().equals(new Posicion(5,5)));
		assertTrue(gohan.getPosicion().equals(new Posicion(6,5)));
	}
	
	
	@Test(expected = ErrorPosicionInvalida.class)
	public void test02cNoSePuedeMoverUnidadAPosicionTomadaPorOtraUnidad() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
	
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		Unidad gohan = new Gohan(null);
		tablero.agregarPosicionable(goku, new Posicion(5,5));
		tablero.agregarPosicionable(gohan, new Posicion(6,5));
		
		tablero.moverUnidad(gohan, new Posicion(6,5));//no deberia mover goku?
}

}
