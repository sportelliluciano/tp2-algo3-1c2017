package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.atributos_de_unidad.modos.GohanNormal;
import model.atributos_de_unidad.modos.GokuNormal;
import model.error.ErrorPosicionInvalida;

public class TestSemana1Consigna03 {

	@Test (expected = ErrorPosicionInvalida.class)
	public void test03aNoSePuedeAtravesarUnidadAmistosa() throws ErrorPosicionInvalida {
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(1,1));
		tablero.agregarUnidad(gohan, new Posicion(2,2));
		
		tablero.moverUnidad(goku, new Posicion(3,3));
	}
	
	@Test (expected = ErrorPosicionInvalida.class)
	public void test03bNoSePuedeAtravesarUnidadEnemiga() throws ErrorPosicionInvalida {
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Unidad(new GokuNormal());
		Unidad gohan = new Unidad(new GohanNormal());
		
		tablero.agregarUnidad(goku, new Posicion(1,1));
		tablero.agregarUnidad(gohan, new Posicion(2,2));
		
		tablero.moverUnidad(goku, new Posicion(3,3));
	}
	
}
