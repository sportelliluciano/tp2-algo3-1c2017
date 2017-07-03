package model.personajes;

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

public class TestGoku {

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarGokuAKaioKenConKiInsuficiienteDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));	

		goku.transformarse();
	}
	
	@Test
	public void testTransformarGokuAKaioKenConKiSuficiente() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));	

		for(int i = 0; i < 4 ; i++)//necesita 20 de ki para transformarse
			   goku.pasarTurno();
		
		goku.transformarse();
		
		assertEquals(goku.getNombre(),"Goku Kaio-ken");
	
	}
	

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarGokuAssjConKiInsuficienteDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
       
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));

		for(int i = 0; i < 4 ; i++)
   			goku.pasarTurno();
 		
		goku.transformarse();
		
		goku.transformarse();//ki insuficiente		
		
	}
	
	@Test
	public void testTransformarGokuAssjConKiInsuficiente() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
       
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(goku, new Posicion(5,5));

		for(int i = 0; i < 4 ; i++)
   			goku.pasarTurno();
 		
		goku.transformarse();
	
		for(int i = 0; i <= 10; i++)//necesita 50 de ki
		    goku.pasarTurno();
		
		goku.transformarse();
		
		assertEquals(goku.getNombre(),"Goku Super Saiyajin");
		
	}
	
	
	@Test
	public void testTirarAtaqueEspecialVerificaAumentoDeDaño() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku, new Posicion(5,5));

		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();
		tablero.agregarPosicionable(freezer, new Posicion(5,6));

		
		for(int i = 0; i < 4 ; i++)//ataque especial cuesta 20 de ki
   			goku.pasarTurno();
 		
		goku.ataqueEspecialA(freezer, tablero);//el ataque especial saca un 20% mas de vida q el basico,es decir,30

	
		assertEquals(freezer.getVida().getVidaActual(),freezer.getVida().getVidaMaxima() - 30);
		
	}
	
	
	
	@Test
	public void testGokuConVidaInferiorAlTreintaPorcientoAumentePoderPeleaVeintePorciento() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();//poder de ataque = 20
		tablero.agregarPosicionable(goku, new Posicion(5,5));

		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();//poder de ataque = 20
		tablero.agregarPosicionable(freezer, new Posicion(5,6));

		//lo dejo con menos de 150 puntos de vida
		for(int i = 0; i < 18 ; i++)//ataque especial cuesta 20 de ki
   			freezer.ataqueBasicoA(goku, tablero);
 		
        goku.ataqueBasicoA(freezer, tablero);//ahora goku esta habilitado para aumentar un 20% su poder
	
		assertEquals(freezer.getVida().getVidaActual(),freezer.getVida().getVidaMaxima() - 24 );
		
	}	
	
		
	@Test
	public void testGokuTiraAtaqueEspecialConVidaInferiorAlTreintaPorcientoAumenteDaño() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();//poder de ataque = 20
		tablero.agregarPosicionable(goku, new Posicion(5,5));

		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();//poder de ataque = 20
		tablero.agregarPosicionable(freezer, new Posicion(5,6));

		//lo dejo con menos de 150 puntos de vida
		for(int i = 0; i < 18 ; i++)//ataque especial cuesta 20 de ki
   			freezer.ataqueBasicoA(goku, tablero);
            
		//ahora goku esta habilitado para aumentar un 20% su poder
 		
		for(int i = 0; i < 4;i++)//necesita 20 de ki para el ataque especial
			goku.pasarTurno();
		
        goku.ataqueEspecialA(freezer, tablero);//el ataque especial hace 30 de daño
        
		assertEquals(freezer.getVida().getVidaActual(),freezer.getVida().getVidaMaxima() - 36 );
		
	}	
	
}
