package model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import model.Direccion;
import model.Posicion;

public class TestPosicion {

	@Test
	public void testEqualsObjetosPosicion() {
		assertTrue(new Posicion(1,1).equals(new Posicion(1,1)));
		assertTrue(new Posicion(0,0).equals(new Posicion(0,0)));
		assertTrue(new Posicion(1,0).equals(new Posicion(1,0)));
		assertTrue(new Posicion(0,1).equals(new Posicion(0,1)));
		assertFalse(new Posicion(1,1).equals(new Posicion(0,0)));
	}
	
	@Test
	public void testEqualsObjetosDeDiferenteClaseDebeDevolverFalse() {
		assertFalse(new Posicion(1,1).equals(new String()));
		assertFalse(new Posicion(1,1).equals(new Object()));
	}
	
	@Test
	public void testEqualsDebeDevolverTrueParaLaMismaInstancia() {
		Posicion posicion = new Posicion(0,0);
		assertTrue(posicion.equals(posicion));
	}
	
	@Test
	public void testGetVecinosSinDiagonalesDevuelveSolamenteArribaAbajoDerechaIzq() {
		Posicion p = new Posicion(0,0);
		Set<Posicion> vecinos = p.getVecinos(Direccion.getDireccionesSinDiagonales());
		assertTrue(vecinos.remove(new Posicion( 0, 1)));
		assertTrue(vecinos.remove(new Posicion( 1, 0)));
		assertTrue(vecinos.remove(new Posicion(-1, 0)));
		assertTrue(vecinos.remove(new Posicion( 0,-1)));
		
		assertFalse(vecinos.remove(new Posicion(0,0)));
		assertEquals(0, vecinos.size());
	}

	@Test
	public void testGetVecinosConDiagonalesDevuelveSolamenteLos8Adyacentes() {
		Posicion p = new Posicion(0,0);
		Set<Posicion> vecinos = p.getVecinos(Direccion.getDireccionesConDiagonales());
		assertTrue(vecinos.remove(new Posicion( 0, 1)));
		assertTrue(vecinos.remove(new Posicion( 1, 0)));
		assertTrue(vecinos.remove(new Posicion(-1, 0)));
		assertTrue(vecinos.remove(new Posicion( 0,-1)));
		
		assertTrue(vecinos.remove(new Posicion( 1, 1)));
		assertTrue(vecinos.remove(new Posicion(-1, 1)));
		assertTrue(vecinos.remove(new Posicion(-1,-1)));
		assertTrue(vecinos.remove(new Posicion( 1,-1)));
		
		assertFalse(vecinos.remove(new Posicion(0,0)));
		assertEquals(0, vecinos.size());
	}
}
