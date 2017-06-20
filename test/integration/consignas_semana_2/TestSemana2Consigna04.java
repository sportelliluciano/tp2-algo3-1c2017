package integration.consignas_semana_2;

import static org.junit.Assert.assertTrue;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.ataque.AtaqueBasico;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;

public class TestSemana2Consigna04 {
	
  	public void test04TransformarPiccoloAprotectorConGohanConMenosDeVeintePorcientoDeVidaCambiaModo() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
	    	Tablero tablero = new Tablero(20,20);
		    GuerrerosZ guerreros = new GuerrerosZ();
		
		    Unidad gohan = guerreros.getGohan(),goku = guerreros.getGoku(), piccolo = guerreros.getPiccolo();	
		
	    	tablero.agregarUnidad(gohan, new Posicion(3,3));
		    tablero.agregarUnidad(goku, new Posicion(3,4));
		    tablero.agregarUnidad(piccolo, new Posicion(4,3));

		    for (int i = 0; i < 4; i++) // Piccolo requiere 20 ki para SSJ1 y 
			      piccolo.pasarTurno();		// carga 5 ki por turno.
		
		    piccolo.transformarse();
		
	      AtaqueBasico ataque = new AtaqueBasico(270);
		
		    gohan.recibirAtaque(ataque);//tiene 300 de vida entonces lo dejo con 30 puntos(10%)
		
		    piccolo.transformarse();
		
		    assertTrue(gohan.getModo().getNombre().equals("Piccolo Protector"));

	}
	
}
