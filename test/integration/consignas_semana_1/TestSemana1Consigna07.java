package integration.consignas_semana_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.Freezer;
import model.personajes.Gohan;
import model.personajes.Goku;

public class TestSemana1Consigna07 {
	
	@Test(expected = ErrorEnemigoFueraDeAlcance.class)  
	public void test07NoSePuedeAtacarEnemigosMuyLejos() throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		
		Tablero tablero = new Tablero(20,20);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad goku = guerreros.getGoku();
		Unidad freezer = enemigos.getFreezer();
		
		tablero.agregarUnidad(goku, new Posicion(3,3));//distancia de ataque = 2
		tablero.agregarUnidad(freezer, new Posicion(15,15));//se encuentra a distancia = 12

		goku.ataqueBasicoA(freezer,tablero);
		
	}		
	
	@Test
	public void test07AtacarEnemigoCercanoReduceSuVida() throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida  {
		Tablero tablero = new Tablero(20,20);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Unidad goku = guerreros.getGoku(); //500 puntos de vida y poder de pelea = 20

		Unidad freezer = enemigos.getFreezer(); //400 puntos de vida
		
		Posicion posGoku =  new Posicion(3,3),posFreezer = new Posicion(4,4);
		
		tablero.agregarUnidad(goku,posGoku);//distancia de ataque = 2
		tablero.agregarUnidad(freezer,posFreezer );//se encuentra a distancia = 1
		
		int vidaOponenteAntesDeAtaque = freezer.getVidaActual();
		
		goku.ataqueBasicoA(freezer,tablero);
		
		assertEquals(freezer.getVidaActual(),(vidaOponenteAntesDeAtaque - 20));
		
	}
	
}
