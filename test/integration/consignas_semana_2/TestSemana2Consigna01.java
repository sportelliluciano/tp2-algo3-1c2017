package integration.consignas_semana_2;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;

public class TestSemana2Consigna01 {
	
	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void test01TransformarGohanConCompañerosConVidaMayorAlTreintaPorcientoDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Tablero tablero = new Tablero(20,20);
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Unidad gohan = guerreros.getGohan(),goku = guerreros.getGoku(), piccolo = guerreros.getPiccolo();	
		
		tablero.agregarUnidad(gohan, new Posicion(3,3));
		tablero.agregarUnidad(goku, new Posicion(3,4));
		tablero.agregarUnidad(piccolo, new Posicion(4,3));

		for (int i = 0; i < 2; i++) // Gohan requiere 10 ki para SSJ1 y 
			gohan.pasarTurno();		// carga 5 ki por turno.
		
		gohan.transformarse();
		
		for (int i = 0; i < 6; i++) // Gohan requiere 30 ki para SSJ2 y 
			gohan.pasarTurno();		// carga 5 ki por turno.
		
		gohan.transformarse();//no puede transformar porque necesita que sus aliados tengan menor de 30% vida
		
	}
	
}
