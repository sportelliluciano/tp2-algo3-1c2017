package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadParalizada;
import model.personajes.Goku;
import model.personajes.modos.GokuNormal;

public class TestSemana1Consigna05 {
	
	@Test (expected = ErrorPosicionInvalida.class)
	public void test05AvanzarTresPosicionesConGokuNormal() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		Tablero tablero = new Tablero(20, 20);
		Unidad goku = new Goku(null);
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		tablero.moverUnidad(goku, new Posicion(8,5));
	}
	
	@Test
	public void test05AvanzarTresPosicionesConGokuKaioken() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada {
		Tablero tablero = new Tablero(20, 20);
		Unidad goku = new Goku(null);
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		for (int i = 0; i < 4; i++) // Goku requiere 20 ki para el kaioken y 
			goku.pasarTurno();		// carga 5 ki por turno.
		
		goku.transformarse();
		
		tablero.moverUnidad(goku, new Posicion(8,5));
		assertTrue(goku.getPosicion().equals(new Posicion(8,5)));
	}
}
