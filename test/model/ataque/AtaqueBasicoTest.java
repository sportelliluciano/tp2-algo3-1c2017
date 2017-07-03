package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtaqueBasicoTest {

	final private int TEST_PODER_DE_PELEA = 20;
	
	@Test
	public void testAtaqueBasicoNoTieneEfectos() {
		Ataque ataque = new AtaqueBasico(TEST_PODER_DE_PELEA);
		assertTrue(ataque.efectos().size() == 0);
	}

	@Test
	public void testDanoDelAtaqueBasicoEsIgualAlPoderDePeleaCuandoElEnemigoTieneMenosPoderDePelea() {
		Ataque ataque = new AtaqueBasico(TEST_PODER_DE_PELEA);
		assertEquals(TEST_PODER_DE_PELEA, ataque.getDano(TEST_PODER_DE_PELEA - 1));
	}
	@Test
	public void testDanoDelAtaqueBasicoEs80pDelPoderDePeleaCuandoElEnemigoTieneMasPoderDePelea() {
		Ataque ataque = new AtaqueBasico(TEST_PODER_DE_PELEA);
		assertEquals(TEST_PODER_DE_PELEA * 0.8, ataque.getDano(TEST_PODER_DE_PELEA + 1), 0.01);
	}
	
	@Test
	public void testDanoDelAtaqueBasicoEsIgualAlPoderDePeleaCuandoElEnemigoTieneMismoPoderDePelea() {
		Ataque ataque = new AtaqueBasico(TEST_PODER_DE_PELEA);
		assertEquals(TEST_PODER_DE_PELEA, ataque.getDano(TEST_PODER_DE_PELEA), 0.01);
	}
}
