package model.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

public class RayoMortalTest {
	private int TEST_PODER_PELEA = 20;
	
	@Test
	public void testRayoMortalNoTieneEfectos() {
		Ataque ataque = new RayoMortal(TEST_PODER_PELEA);
		assertEquals(0, ataque.efectos().size());
	}
	
	@Test
	public void testDanoDeRayoMortalEs50pMasQueElPoderDePelea() {
		Ataque rayoMortal = new RayoMortal(TEST_PODER_PELEA);
		Ataque basico     = new AtaqueBasico(TEST_PODER_PELEA);
		assertEquals((int)(basico.getDano(TEST_PODER_PELEA) * 1.5), rayoMortal.getDano(TEST_PODER_PELEA));
	}
}
