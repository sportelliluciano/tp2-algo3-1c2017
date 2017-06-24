package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

public class KamehamehaTest {

	private int TEST_PODER_PELEA = 20;
	
	@Test
	public void testKamehamehaNoTieneEfectos() {
		Ataque ataque = new Kamehameha(TEST_PODER_PELEA);
		assertEquals(0, ataque.efectos().size());
	}
	
	@Test
	public void testDanoDeKamehamehaEs50pMasQueElPoderDePelea() {
		Ataque kamehameha = new Kamehameha(TEST_PODER_PELEA);
		Ataque basico     = new AtaqueBasico(TEST_PODER_PELEA);
		assertEquals((int)(basico.getDano() * 1.5), kamehameha.getDano());
	}

}
