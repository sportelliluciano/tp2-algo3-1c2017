package integration.consignas_semana_2;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.MajinBoo;

public class TestSemana2Consigna08 {

	@Test
	public void test08AtacarConMajinBooUsandoAtaqueEspecialConvierteEnChocolate() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {

                Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarUnidad(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();
		tablero.agregarUnidad(majinBoo, new Posicion(5,6));
		
		for(int i = 0; i < 6; i++)
			  majinBoo.pasarTurno();//necesita 30 de ki para ataqueEspecial
			
	        majinBoo.ataqueEspecialA(goku, tablero);
	
   // assertEquals(goku.getEstado().duracionParalisis,3);
	    
	        for(int i = 0 ;i < 3; i++){//goku queda paralizado 3 turnos
	                 assertTrue(goku.getEstado().paralizado());
	    	         goku.pasarTurno();
	         }
	  
	        for(int i = 0 ;i < 3; i++){//majinBoo no carga su ki durante 3 tiempos
	                 majinBoo.pasarTurno();
	                 assertEquals(majinBoo.getKi().getMagnitud(),0);
	        }
    
	}

}
