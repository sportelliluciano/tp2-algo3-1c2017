package integration.consignas_semana_2;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;

public class TestSemana2Consigna03 {
	
	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void test03TransformarPiccoloAprotectorConGohanConMasDeVeintePorcientoDeVidaDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		 Tablero tablero = new Tablero(20,20);
		 GuerrerosZ guerreros = new GuerrerosZ();
		    
		 Unidad gohan = guerreros.getGohan(),goku = guerreros.getGoku(), piccolo = guerreros.getPiccolo();	
		
		 tablero.agregarPosicionable(gohan, new Posicion(3,3));
		 tablero.agregarPosicionable(goku, new Posicion(3,4));
		 tablero.agregarPosicionable(piccolo, new Posicion(4,3));

		 for (int i = 0; i < 4; i++) // Piccolo requiere 20 ki para SSJ1 y 
		    	piccolo.pasarTurno();		// carga 5 ki por turno.
		
		 piccolo.transformarse();
		
		 piccolo.transformarse();//no puede transformar porque necesita que gohan tenga menos de 20% vida
		
	}
	
}
