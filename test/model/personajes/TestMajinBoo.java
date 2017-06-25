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
import model.personajes.Goku;
import model.personajes.MajinBoo;

public class TestMajinBoo {

	@Test
	public void testTransformarMajinBooABooMaloConKiSuficiente() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	

		for(int i = 0; i < 4; i++)//necesita 20 de ki para transformarse
			  majinBoo.pasarTurno();
		
		majinBoo.transformarse(); 
		
		assertEquals(majinBoo.getNombre(),"Boo Malo");

	}
	
	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarMajinBooABooMaloConKiInsuficienteDaError() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	

		majinBoo.transformarse(); 
		
	}

	
	@Test (expected = ErrorNoCumpleReqTrans.class ) 
	public void testTransformarMajinBooABooOriginalConKiInsuficienteDaError() throws ErrorKiInsuficiente, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	

		for(int i = 0; i < 4; i++)//necesita 20 de ki para transformarse
			   majinBoo.pasarTurno();
		
		majinBoo.transformarse(); 
		
		majinBoo.transformarse(); 
		
	}
	
	@Test
	public void testTransformarMajinBooABooOriginalConKiSuficiente() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	
		
		
		for(int i = 0; i < 4; i++)//necesita 20 para la primera
			   majinBoo.pasarTurno();
		
		majinBoo.transformarse(); 
		
		for(int i = 0; i < 10; i++)//necesita 50 para la segunda
			   majinBoo.pasarTurno();
		
		majinBoo.transformarse();
		
		assertEquals(majinBoo.getNombre(),"Boo Original");

	}
	
	@Test
	public void testTirarAtaqueEspecialConKiSuficienteVerificaInmobilidad() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerrerosZ = new GuerrerosZ();
		Goku goku = guerrerosZ.getGoku();
		tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	

		for(int i = 0; i < 6; i++)//necesita 30 de ki para el ataque especial
			   majinBoo.pasarTurno();
		
		majinBoo.ataqueEspecialA(goku, tablero);//lo paraliza y contiene el ki por 3 turnos
		
		int kiGokuAntesDeParalizar = goku.getKi().getMagnitud();
		
		for(int i = 0; i < 3; i++){
			  assertTrue(goku.estaParalizado());
			  assertEquals(goku.getKi().getMagnitud(),kiGokuAntesDeParalizar);
			  goku.pasarTurno();
		}
		
	}
	

	@Test(expected = ErrorKiInsuficiente.class)
	public void testTirarAtaqueEspecialConKiInsuficienteDaError() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerrerosZ = new GuerrerosZ();
		Goku goku = guerrerosZ.getGoku();
		tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();
		tablero.agregarPosicionable(majinBoo, new Posicion(5,5));	
		
		majinBoo.ataqueEspecialA(goku, tablero);

	}
	
}
