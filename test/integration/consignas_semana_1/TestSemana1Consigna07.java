package integration.consignas_semana_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorPosicionInvalida;
import model.personajes.Freezer;
import model.personajes.Gohan;
import model.personajes.Goku;

public class TestSemana1Consigna07 {
	
	@Test(expected = ErrorEnemigoFueraDeAlcance.class)  
	public void test07NoSePuedeAtacarEnemigosMuyLejos() throws ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku();
		Unidad freezer = new Gohan();
		
		tablero.agregarUnidad(goku, new Posicion(3,3));//distancia de ataque = 2
		tablero.agregarUnidad(freezer, new Posicion(15,15));//se encuentra a distancia = 12

		goku.ataqueBasicoA(freezer);
		
	}		
	
	@Test
	public void test07AtacarEnemigoCercanoReduceSuVida()throws ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida  {
		Tablero tablero = new Tablero(20,20);
		
		Unidad goku = new Goku(); //500 puntos de vida y poder de pelea = 20

		Unidad freezer = new Freezer(); //400 puntos de vida
		
		Posicion posGoku =  new Posicion(3,3),posFreezer = new Posicion(4,4);
		
		tablero.agregarUnidad(goku,posGoku);//distancia de ataque = 2
		tablero.agregarUnidad(freezer,posFreezer );//se encuentra a distancia = 1
		
		int vidaOponenteAntesDeAtaque = freezer.getVidaActual();
		
		goku.ataqueBasicoA(freezer);
		
		assertEquals(freezer.getVidaActual(),(vidaOponenteAntesDeAtaque - 20));
		
	}
	
}
