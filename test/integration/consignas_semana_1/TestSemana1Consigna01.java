package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GokuNormal;

public class TestSemana1Consigna01 {
	
	@Test
	public void test01MoverUnidadCambiaSuPosicion(){
				
		Tablero tablero = new Tablero();
		Unidad goku = new Unidad(new GokuNormal());
		tablero.agregarUnidad(goku, new Posicion(5,5));
		
		tablero.moverUnidad(goku, new Posicion(6,5));
		assertTrue(goku.getPosicion().equals(new Posicion(6,5)));
		
	}
}
