package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

import model.efectos.Paralizante;

public class ConvierteteEnChocolateTest {

	@Test
	public void testDanoDeConvierteteEnChocolateEs0() {
		Ataque ataque = new ConvierteteEnChocolate();
		assertEquals(0, ataque.getDano());
	}
	
	@Test
	public void testConvierteteEnChocolateTieneSolamenteEfectoParalizante() {
		Ataque ataque = new ConvierteteEnChocolate();
		assertEquals(1, ataque.efectos().size());
		assertTrue(ataque.efectos().get(0) instanceof Paralizante);
	}

}
