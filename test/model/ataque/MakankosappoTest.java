package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

public class MakankosappoTest {

	private int TEST_PODER_PELEA = 20;
	
	@Test
	public void testMakankosappoNoTieneEfectos() {
		Ataque ataque = new Makankosappo(TEST_PODER_PELEA);
		assertEquals(0, ataque.efectos().size());
	}
	
	@Test
	public void testDanoDeMakankosappoEs25pMasQueElPoderDePelea() {
		Ataque makankosappo = new Makankosappo(TEST_PODER_PELEA);
		Ataque basico       = new AtaqueBasico(TEST_PODER_PELEA);
		assertEquals((int)(basico.getDano() * 1.25), makankosappo.getDano());
	}

}
