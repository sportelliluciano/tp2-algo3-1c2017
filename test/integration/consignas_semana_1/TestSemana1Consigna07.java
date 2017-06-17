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
import model.personajes.modos.FreezerNormal;
import model.personajes.modos.GokuNormal;

public class TestSemana1Consigna07 {
	
	@Test(expected = ErrorEnemigoFueraDeAlcance.class)  
	public void test07NoSePuedeAtacarEnemigosMuyLejos() throws ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero(20,20);
		Unidad goku = new Goku();
		Unidad freezer = new Gohan();
		
		tablero.agregarUnidad(goku, new Posicion(3,3));//distancia de ataque = 2
		tablero.agregarUnidad(freezer, new Posicion(15,15));//se encuentra a distancia = 12

		goku.atacarBasicoA(freezer);
		
	}		
	
	@Test
	public void test07AtacarEnemigoCercanoReduceSuVida()throws ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida  {
		Tablero tablero = new Tablero(20,20);
		
		Unidad goku = new Goku(); //500 puntos de vida y poder de pelea = 20
		goku.setVida(500);

		Unidad freezer = new Freezer(); //400 puntos de vida
		freezer.setVida(400);
		
		Posicion posGoku =  new Posicion(3,3),posFreezer = new Posicion(4,4);
		
		tablero.agregarUnidad(goku,posGoku);//distancia de ataque = 2
		tablero.agregarUnidad(freezer,posFreezer );//se encuentra a distancia = 1
		
		int vidaOponenteAntesDeAtaque = freezer.getVida();
		
		goku.atacarBasicoA(freezer);
		
		assertEquals(freezer.getVida(),(vidaOponenteAntesDeAtaque - goku.getAtaqueBasico()));
		
	}
	
}
