import static org.junit.Assert.*;

import org.junit.Test;
package test.model;

import model.Posicion;
import model.Tablero;
import model.consumibles.EsferaDelDragon;
import model.consumibles.NubeVoladora;
import model.consumibles.Semilla;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.Freezer;
import model.personajes.Goku;

public class TestConsumibles {

	@Test
	public void testAgarrarEsferaIncrementaEnLosDosTurnosSiguientesAtaque() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();//la vida de freezer es de 400
		tablero.agregarPosicionable(freezer, new Posicion(5,6));
		
		EsferaDelDragon esfera = new EsferaDelDragon();
		
		goku.aplicarConsumible(esfera);//da 25% mas de daño en cada ataque durante los prox's 2 turnos
		
		int vidaFreezerAntesAtaque = freezer.getVidaActual();
		
		for(int i = 0; i < 2; i++){
			goku.ataqueBasicoA(freezer, tablero);
	        goku.pasarTurno();
		}
		
		assertEquals(vidaFreezerAntesAtaque - 50, freezer.getVidaActual());

		
	}
	
	@Test
	public void testConsumirSemillaRegeneraCienDeVida() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();//la vida de freezer es de 400
		tablero.agregarPosicionable(freezer, new Posicion(5,6));
		
		Semilla semilla = new Semilla();
				
		for(int i = 0; i < 15; i++){
			goku.ataqueBasicoA(freezer, tablero);
	        goku.pasarTurno();
		}
		
		int vidaFreezerDespuesAtaque = freezer.getVidaActual();

		freezer.aplicarConsumible(semilla);//regenera 100 de vida

		assertEquals( freezer.getVidaActual(),vidaFreezerDespuesAtaque + 100);
		
	}
	

	@Test
	public void testAgarrarNubeVoladoraDuplicaVelocidadDePersonaje() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorUnidadParalizada {
        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();//velocidad = 2
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		int velocidadGokuAntesDeNubeVoladora = goku.getModo().getVelocidad();
		
		NubeVoladora nubeVoladora = new NubeVoladora();
				
		goku.aplicarConsumible(nubeVoladora);//velociad = 2x2 = 4 (x2 turnos)
		
		assertEquals(goku.getModo().getVelocidad(),velocidadGokuAntesDeNubeVoladora*2);
		
		goku.moverA(new Posicion(5,9), tablero);
		assertEquals(goku.getPosicion(),new Posicion(5,9));
        goku.pasarTurno();
        goku.moverA(new Posicion(9,9), tablero);
		assertEquals(goku.getPosicion(),new Posicion(9,9));
		
	}
	
	
}
