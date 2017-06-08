package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GokuNormal;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorPosicionInvalida;

public class TestSemana1Consigna05 {
	
	@Test (expected = RuntimeException.class)
	public void test05AvanzarTresPosicionesConGokuNormal() throws ErrorPosicionInvalida {
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		tablero.moverUnidad(goku, new Posicion(8,5));
	}
	
	@Test
	public void test05AvanzarTresPosicionesConGokuKaioken() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans {
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		for (int i = 0; i < 4; i++) // Goku requiere 20 ki para el kaioken y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		tablero.moverUnidad(goku, new Posicion(8,5));
		assertTrue(goku.getPosicion().equals(new Posicion(8,5)));
	}
}
