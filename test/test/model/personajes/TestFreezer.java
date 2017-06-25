package test.model.personajes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.Freezer;
import model.personajes.Goku;

public class TestFreezer {

	@Test
	public void testTransformarFreezerAsegundaFormaConKiSuficiente() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {		
		   EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		   Freezer freezer = enemigos.getFreezer();

		   Tablero tablero = new Tablero(19,23);
		
		   tablero.agregarPosicionable(freezer, new Posicion(5,5));	

		   for(int i = 0; i < 4; i++)
			     freezer.pasarTurno();
		
		   freezer.transformarse(); 
		
		   assertEquals(freezer.getNombre(),"Freezer Segunda Forma");

	}

	
	@Test (expected = ErrorNoCumpleReqTrans.class ) 
	public void testTransformarFreezerAsegundaFormaConKiInsuficienteDaError() throws ErrorKiInsuficiente, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {		
		   EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		   Freezer freezer = enemigos.getFreezer();

		   Tablero tablero = new Tablero(19,23);
		
	     tablero.agregarPosicionable(freezer, new Posicion(5,5));	
		
		   freezer.transformarse(); 
	}
	
	@Test
	public void testTransformarFreezerAdefinitivo() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {		
		  EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		  Freezer freezer = enemigos.getFreezer();

		  Tablero tablero = new Tablero(19,23);
		
	  	tablero.agregarPosicionable(freezer, new Posicion(5,5));	

		  for(int i = 0; i < 4; i++)
			    freezer.pasarTurno();
		
		  freezer.transformarse(); 
		
		  for(int i = 0; i < 10; i++)
			   freezer.pasarTurno();
		
		  freezer.transformarse();
		
		  assertEquals(freezer.getNombre(),"Freezer Definitivo");

	}
	
	@Test
	public void testTirarAtaqueEspecialConKiSuficienteVerificaDaño() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		  Tablero tablero = new Tablero(19,23);
		
		  GuerrerosZ guerrerosZ = new GuerrerosZ();
		  Goku goku = guerrerosZ.getGoku();
		  tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
	  	EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
	  	Freezer freezer = enemigos.getFreezer();
		  tablero.agregarPosicionable(freezer, new Posicion(5,5));	

		  for(int i = 0; i < 4; i++)//necesita 20 de ki para el ataque especial
			    freezer.pasarTurno();
		
		  freezer.ataqueEspecialA(goku, tablero);//hace 30 de daño(50% mas del ataque)
		
		  assertEquals(goku.getVida().getVidaActual(),goku.getVida().getVidaMaxima() - 30);

	}
	

	@Test(expected = ErrorKiInsuficiente.class)
	public void testTirarAtaqueEspecialConKiInsuficienteDaError() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
	  	Tablero tablero = new Tablero(19,23);
		
		  GuerrerosZ guerrerosZ = new GuerrerosZ();
	  	Goku goku = guerrerosZ.getGoku();
		  tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
		  EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		  Freezer freezer = enemigos.getFreezer();
	  	tablero.agregarPosicionable(freezer, new Posicion(5,5));	
		
		  freezer.ataqueEspecialA(goku, tablero);

	}
	
}
