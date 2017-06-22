package integration.consignas_semana_2;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.Freezer;
import model.personajes.Goku;

public class TestSemana2Consigna09 {

	@Test
	public void test09GokuAumentaDañoAlReducirVidaDeBajoAlVeintePorciento() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
    Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarUnidad(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();//la vida de freezer es de 400
		tablero.agregarUnidad(freezer, new Posicion(5,6));
		
		for(int i = 0; i <= 20; i++ )
		     freezer.ataqueBasicoA(goku, tablero);//saca 20 de vida
        //goku queda con menos de 20% de vida	
		
		int vidaFreezerAntesAtaque = freezer.getVidaActual();
		
		goku.ataqueBasicoA(freezer, tablero);
				
		assertEquals(vidaFreezerAntesAtaque - 24, freezer.getVidaActual());//aumenta un 20% entonces es 24 el daño que hace goku
		
	}

}
