package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasenkoTest {
	
	private int TEST_PODER_PELEA = 20;

	@Test
	public void testMasenkoNoTieneEfectos() {
		Ataque ataque = new Masenko(TEST_PODER_PELEA);
		assertEquals(0, ataque.efectos().size());
	}
	
	@Test
	public void testDanoDeMasenkoEs25pMasQueElAtaqueBasico() {
		Ataque masenko = new Masenko(TEST_PODER_PELEA);
		Ataque basico  = new AtaqueBasico(TEST_PODER_PELEA);
		assertEquals((int)(basico.getDano() * 1.25), masenko.getDano());
	}
}
