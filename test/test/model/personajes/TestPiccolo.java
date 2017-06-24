package test.model.personajes;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.Freezer;
import model.personajes.Gohan;
import model.personajes.Piccolo;

public class TestPiccolo {

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarPiccioloAfortalecidoConKiInsuficiienteDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(piccolo, new Posicion(5,5));	

		piccolo.transformarse();
	}
	
	@Test
	public void testTransformarPiccioloAfortalecidoConKiSuficiente() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(piccolo, new Posicion(5,5));	

		for(int i = 0; i < 4 ; i++)
			   piccolo.pasarTurno();
		
		piccolo.transformarse();
		
		assertEquals(piccolo.getNombre(),"Piccolo Fortalecido");
	
	}
	

	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarPiccoloAProtectorConGohanConVidaSuperiorVeintePorcientoDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();
                Gohan gohan = guerreros.getGohan();//300 de vida
       
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(piccolo, new Posicion(5,5));
		tablero.agregarPosicionable(gohan, new Posicion(10,10));	
		tablero.agregarPosicionable(freezer, new Posicion(11,10));	

		for(int i = 0; i < 4 ; i++)
   			piccolo.pasarTurno();
 		
		piccolo.transformarse();
		
		piccolo.transformarse();//gohan esta sin daño		
		
	}
	
	@Test
	public void testTransformarPiccioloAProtectorConGohanConVidaInferiorVeintePorciento() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();
    Gohan gohan = guerreros.getGohan();//300 de vida
        
    EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
    Freezer freezer = enemigos.getFreezer();
		
		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(piccolo, new Posicion(5,5));	
		tablero.agregarPosicionable(gohan, new Posicion(10,10));	
		tablero.agregarPosicionable(freezer, new Posicion(11,10));	

		for(int i = 0; i < 4 ; i++)
		   	piccolo.pasarTurno();
		
		piccolo.transformarse();
	
		//lo dejo con menos de 60 de vida
		for(int i = 0; i <= 12; i++)
		    freezer.ataqueBasicoA(gohan, tablero);//cada ataque saca 20
		
		piccolo.transformarse();
		
		assertEquals(piccolo.getNombre(),"Piccolo Protector");
		
	}
	
}
