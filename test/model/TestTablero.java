package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadParalizada;
import model.personajes.Cell;
import model.personajes.Freezer;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.MajinBoo;
import model.personajes.Piccolo;
import model.Posicion;
import model.Tablero;
import model.consumibles.EsferaDelDragon;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;

public class TestTablero {

	@Test (expected = ErrorPosicionInvalida.class ) 
	public void testAgregarPosicionableEnLugarOcupadoDaError() throws ErrorPosicionInvalida{
        Tablero tablero = new Tablero(19,23);
        
        EsferaDelDragon esfera = new EsferaDelDragon();
         
        tablero.agregarPosicionable(esfera, new Posicion(5,5));
        
        tablero.agregarPosicionable(new Goku(new GuerrerosZ()), new Posicion(5,5));
	
	}

	@Test 
	public void testAgregarPosicionableEnLugarLibreVerificaLugarOcupado() throws ErrorPosicionInvalida{
        Tablero tablero = new Tablero(19,23);
        
        EsferaDelDragon esfera = new EsferaDelDragon();
         
        assertFalse(tablero.hayPosicionableEn(new Posicion(5,5)));
        
        tablero.agregarPosicionable(esfera, new Posicion(5,5));
        
        assertTrue(tablero.hayPosicionableEn(new Posicion(5,5)));
        	
	}
	
	@Test 
	public void testEstaDentroDelAlcance() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans{
    Tablero tablero = new Tablero(19,23);
        
    GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();//distacia de ataque  = 2
		Posicion posPiccolo =  new Posicion(5,5);
		tablero.agregarPosicionable(piccolo,posPiccolo);
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
    Freezer freezer = enemigos.getFreezer();
		Posicion posFreezer =  new Posicion(5,9);
		tablero.agregarPosicionable(freezer, posFreezer);
	    		
		assertFalse(tablero.estaDentroDelAlcance(posPiccolo,posFreezer, 2));
		
		for(int i = 0; i < 4; i++)
		  	piccolo.pasarTurno();
		
		piccolo.transformarse();//distancia de ataque 4
		
		assertTrue(tablero.estaDentroDelAlcance(posPiccolo,posFreezer, 4));
        	
	}
	
	
	
	@Test 
	public void testPosionesDeUnidadesNoPertenecenAmovimientosPosibles() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada{
    Tablero tablero = new Tablero(19,23);
        
    GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();//velocidad  = 2
		Posicion posPiccolo =  new Posicion(5,5);
		tablero.agregarPosicionable(piccolo,posPiccolo);
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
    Freezer freezer = enemigos.getFreezer();
		Posicion posFreezer =  new Posicion(5,8);
		tablero.agregarPosicionable(freezer, posFreezer);
	    		
		assertFalse(tablero.getMovimientosPosibles(posPiccolo, piccolo.getVelocidad()).contains(posFreezer));
		
		for(int i = 0; i < 4; i++)
		   	piccolo.pasarTurno();
		
		piccolo.transformarse();//velocidad = 3
		
		assertFalse(tablero.getMovimientosPosibles(posPiccolo, piccolo.getVelocidad()).contains(posFreezer));

		EsferaDelDragon esfera = new EsferaDelDragon();
		Posicion posEsfera = new Posicion(6,6);
		tablero.agregarPosicionable(esfera,posEsfera);
		
		assertFalse(tablero.getMovimientosPosibles(posPiccolo, piccolo.getVelocidad()).contains(posEsfera));
        	
	}
	
	@Test 
	public void testAgregarEquiposRespetaPosEsquinaDiagonal() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada{
    Tablero tablero = new Tablero(19,23);
        
    GuerrerosZ guerreros = new GuerrerosZ();
		Piccolo piccolo = guerreros.getPiccolo();
		Gohan gohan = guerreros.getGohan();
		Goku goku = guerreros.getGoku();
	
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
	  Freezer freezer = enemigos.getFreezer();
    Cell cell = enemigos.getCell();
    MajinBoo majinBoo= enemigos .getMajinBoo();
	  
		Posicion posEsquinaSupIzq1 = (new Posicion(2,0));
		Posicion posEsquinaSupIzq2= (new Posicion(0,2));
		Posicion posEsquinaSupIzq3 = (new Posicion(1,1));
		Posicion posEsquinaInfDer1 = (new Posicion(16,22));
		Posicion posEsquinaInfDer2 = (new Posicion(18,20));
		Posicion posEsquinaInfDer3 = (new Posicion(17,21));
		
		tablero.agregarEquipos(guerreros, enemigos);
		
		assertTrue(tablero.hayPosicionableEn(posEsquinaSupIzq1));
		assertTrue(tablero.hayPosicionableEn(posEsquinaSupIzq2));
		assertTrue(tablero.hayPosicionableEn(posEsquinaSupIzq3));
		assertTrue(tablero.hayPosicionableEn(posEsquinaInfDer1));
		assertTrue(tablero.hayPosicionableEn(posEsquinaInfDer2));
		assertTrue(tablero.hayPosicionableEn(posEsquinaInfDer3));
        	
	}
	
	

}
