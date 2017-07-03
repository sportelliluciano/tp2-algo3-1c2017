package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Unidad;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.personajes.Goku;

public class TestSemana1Consigna04 {
	
	@Test
	public void test04aTransformarseCambiaElModo() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Unidad goku = new Goku(null);	
		for (int i = 0; i < 4; i++) // Goku requiere 20 ki para el kaioken y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		assertTrue(goku.getNombre().equals("Goku Kaio-ken"));
	}
	
	@Test (expected = ErrorNoCumpleReqTrans.class)
	public void test04bTransformarseConKiInsuficienteLanzaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Unidad goku = new Goku(null);
		
		goku.transformarse();
	}
	
	@Test (expected = ErrorNoHayMasTrans.class)
	public void test04bTransformarseEstandoEnUltimaTransformacionLanzaError() throws ErrorNoCumpleReqTrans, ErrorPosicionInvalida, ErrorNoHayMasTrans {
		Unidad goku = new Goku(null);	
		for (int i = 0; i < 4; i++) // Goku requiere 20 ki para el kaioken y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		for (int i = 0; i < 10; i++) // Goku requiere 50 ki para el SSJ y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		goku.transformarse();// no hay mas transformaciones		

	}
	
}
