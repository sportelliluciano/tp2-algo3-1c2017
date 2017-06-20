package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.*;
import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.error.*;
import model.personajes.Goku;
import model.personajes.modos.GokuNormal;

public class TestSemana1Consigna01 {
	
	@Test
	public void test01MoverUnidadCambiaSuPosicion() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
				
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		tablero.moverUnidad(goku, new Posicion(5,4));
		
		assertTrue(goku.getPosicion().equals(new Posicion(5,4)));
		
	}
}
