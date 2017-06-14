package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Unidad;
import model.atributos_de_unidad.modos.GokuNormal;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
//import model.error.ErrorNoHayMasTrans;

public class TestSemana1Consigna04 {
	
	@Test
	public void test04aTransformarseCambiaElModo() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Unidad goku = new Unidad(new GokuNormal());	
		for (int i = 0; i < 4; i++) // Goku requiere 20 ki para el kaioken y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		assertTrue(goku.getModo().getNombre().equals("Kaio-ken"));
	}
	
	@Test (expected = ErrorNoCumpleReqTrans.class)
	public void test04bTransformarseConKiInsuficienteLanzaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Unidad goku = new Unidad(new GokuNormal());
		
		goku.transformarse();
	}
	
	/*
	@Test (expected = ErrorNoHayMasTrans.class)
	public void test04bTransformarseEstandoEnUltimaTransformacionLanzaError() throws ErrorNoCumpleReqTrans, ErrorPosicionInvalida, ErrorNoHayMasTrans {
		Unidad goku = new Unidad(new GokuSSJ());
		
		goku.transformarse();		
	}*/
	
}
