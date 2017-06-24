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
	public void testDanoDelAtaqueBasicoEsIgualAlPoderDePelea() {
		Ataque ataque = new AtaqueBasico(TEST_PODER_DE_PELEA);
		assertEquals(TEST_PODER_DE_PELEA, ataque.getDano());
	}
}
