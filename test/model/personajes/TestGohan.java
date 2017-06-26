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
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class TestGohan {

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarGohanAssfase1ConKiInsuficiienteDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Gohan gohan = guerreros.getGohan();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(gohan, new Posicion(5,5));	

		gohan.transformarse();
	}
	
	@Test
	public void testTransformarGohanAssfase1ConKiSuficiente() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Gohan gohan = guerreros.getGohan();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(gohan, new Posicion(5,5));	

		for(int i = 0; i < 2 ; i++)//necesita 10 de ki para transformarse
			   gohan.pasarTurno();
		
		gohan.transformarse();
		
		assertEquals(gohan.getNombre(),"Gohan Super Sayajin fase 1");
	
	}
	

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarGohanAssjfase2ConKiInsuficienteDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Gohan gohan = guerreros.getGohan();
       
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(gohan, new Posicion(5,5));

		for(int i = 0; i < 2 ; i++)//necesita 10 de ki para transformarse
   			gohan.pasarTurno();
 		
		gohan.transformarse();
		
		gohan.transformarse();//ki insuficiente		
		
	}
	
	@Test
	public void testTransformarGohanAssjfase2ConKiInsuficiente() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Gohan gohan = guerreros.getGohan();
		Piccolo piccolo = guerreros.getPiccolo();//500 de vida
		Goku goku = guerreros.getGoku();//500 de vida
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
        Freezer freezer = enemigos.getFreezer();// poder de ataque = 20
		
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(gohan, new Posicion(0,0));
		tablero.agregarPosicionable(goku, new Posicion(5,6));
		tablero.agregarPosicionable(piccolo, new Posicion(4,5));
		
		tablero.agregarPosicionable(freezer, new Posicion(5,5));


		for(int i = 0; i < 2 ; i++)
   			gohan.pasarTurno();
 		
		gohan.transformarse();//fase 1
	
		for(int i = 0; i <= 10; i++)//necesita 30 de ki 
		    gohan.pasarTurno();
		
		for(int i = 0; i <=17; i++){//tienen que quedar con menos del 30 porciento de vida(menos de 150)
		    freezer.ataqueBasicoA(goku, tablero);
		    freezer.ataqueBasicoA(piccolo, tablero);
		}
		
		gohan.transformarse();
		
		assertEquals(gohan.getNombre(),"Gohan Super Sayajin Fase 2");
		
	}
	
	
	@Test
	public void testTirarAtaqueEspecialVerificaAumentoDeDaño() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Gohan gohan = guerreros.getGohan();
		tablero.agregarPosicionable(gohan, new Posicion(5,5));

		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Freezer freezer = enemigos.getFreezer();
		tablero.agregarPosicionable(freezer, new Posicion(5,6));

		
		for(int i = 0; i < 2 ; i++)//ataque especial cuesta 10 de ki
   			gohan.pasarTurno();
 		
		gohan.ataqueEspecialA(freezer, tablero);//el ataque especial saca un 25% mas de vida q el basico,es decir,30

	
		assertEquals(freezer.getVida().getVidaActual(),freezer.getVida().getVidaMaxima() - 18,75);
		
	}
		
}
