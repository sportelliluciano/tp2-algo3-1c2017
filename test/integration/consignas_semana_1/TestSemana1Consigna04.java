package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSemana1Consigna04 {
	
	@Test
	public void test04aTransformarseCambiaElModo() throws ErrorKiInsuficiente {
		// TODO: Implement
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		goku.incrementarKi(20);
        goku.transformarAkaioken();
		assertTrue(goku.getModo().getNombre().equals("Kaio-Ken"));
	}
	
	@Test (expected = RuntimeException.class)
	public void test04bTransformarseConKiInsuficienteLanzaError() throws ErrorKiInsuficiente {
		// TODO: Implement
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		goku.incrementarKi(5);
        
		goku.transformarAkaioken();
	}
	
}
