package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadParalizada;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.modos.GohanNormal;
import model.personajes.modos.GokuNormal;

public class TestSemana1Consigna03 {

	@Test (expected = ErrorPosicionInvalida.class)
	public void test03aNoSePuedeAtravesarUnidadAmistosa() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		Unidad gohan = new Gohan(null);
		
		tablero.agregarUnidad(goku, new Posicion(1,1));
		tablero.agregarUnidad(gohan, new Posicion(2,2));
		
		tablero.moverUnidad(goku, new Posicion(3,3));
	}
	
	@Test (expected = ErrorPosicionInvalida.class)
	public void test03bNoSePuedeAtravesarUnidadEnemiga() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku(null);
		Unidad gohan = new Gohan(null);
		
		tablero.agregarUnidad(goku, new Posicion(1,1));
		tablero.agregarUnidad(gohan, new Posicion(2,2));
		
		tablero.moverUnidad(goku, new Posicion(3,3));
	}
	
}
