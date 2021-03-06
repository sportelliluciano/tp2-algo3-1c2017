package integration.consignas_semana_2;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.MajinBoo;

public class TestSemana2Consigna08 {

	@Test
	public void test08AtacarConMajinBooUsandoAtaqueEspecialConvierteEnChocolate() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorUnidadParalizada {

        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		MajinBoo majinBoo = enemigos.getMajinBoo();
		tablero.agregarPosicionable(majinBoo, new Posicion(5,6));
		
		for(int i = 0; i < 6; i++)
			majinBoo.pasarTurno();//necesita 30 de ki para ataqueEspecial
			
        majinBoo.ataqueEspecialA(goku, tablero);
   
        int kiGoku = goku.getKi().getMagnitud();
        for(int i = 0 ;i < 3; i++) { //goku queda paralizado 3 turnos y no carga ki en ese tiempo
             assertTrue(goku.estaParalizado());
             assertEquals(kiGoku, goku.getKi().getMagnitud());
	         goku.pasarTurno();
         }
	}

}
