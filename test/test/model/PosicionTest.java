package test.model;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.Posicion;
import model.error.ErrorPosicionInvalida;

public class PosicionTest {

	@Test
	public void testEquals() throws ErrorPosicionInvalida {
		assertTrue(new Posicion(1,1).equals(new Posicion(1,1)));
		assertTrue(new Posicion(0,0).equals(new Posicion(0,0)));
		assertTrue(new Posicion(1,0).equals(new Posicion(1,0)));
		assertTrue(new Posicion(0,1).equals(new Posicion(0,1)));
		assertFalse(new Posicion(1,1).equals(new Posicion(0,0)));
	}
	
	@Test
	public void testGetVecinos() throws ErrorPosicionInvalida {
		Posicion p = new Posicion(0,0);
		Set<Posicion> vecinos = p.getVecinos();
		assertTrue(vecinos.contains(new Posicion(0,1)));
		assertTrue(vecinos.contains(new Posicion(1,0)));
		assertTrue(vecinos.contains(new Posicion(1,1)));
		assertFalse(vecinos.contains(new Posicion(0,0)));
	}

}
