package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

import model.Juego;
import model.Jugador;
import model.Tablero;
import model.Unidad;
	
//No se si esta del todo bien,pero lo pongo para ver si sirve,faltaria el elegir unidades
//en jugador para que pueda devolverlas y asi poder saber las posiciones 
public class TestSemana1Consigna06 {	
	@Test
	public void test06CrearJuegoYValidarPosicionesDeTablero() {
		Jugador jugador1,jugador2;
		jugador1 = new Jugador("Fabio");
		jugador2 = new Jugador("Marito"); // Quien es Marito? XD

		Juego juego = new Juego(jugador1, jugador2);
		
		assertTrue(false);
		/*
		Tablero tablero = juego.getTablero();
		
		int alto = tablero.getAlto();
		int ancho = tablero.getAncho();
		
		// No entiendo que representan estas esquinas, la verdad
		int[][] esquinaSuperiorIzq ={{1,1},{2,1},{1,2}};	
		int[][] esquinaSuperiorDer ={{1,ancho},{2,ancho - 1},{1,ancho}};		
		int[][] esquinaInferiorIzq ={{alto,1},{alto,2},{alto - 1,1}};		
		int[][] esquinaInferiorDer ={{alto,ancho - 1},{alto - 1,ancho},{alto,ancho}};				
				
		int[][] esquinaJugador1 = null, esquinaJugador2 = null;
		
		Vector<Unidad> unidades1,unidades2;
		unidades1 = jugador1.getUnidades(); // <- Esto no se si me gusta
		unidades2 = jugador2.getUnidades(); // <- Esto no se si me gusta
		
		for(int i=0; i < 3; i++){
			esquinaJugador1[i][0] = unidades1.get(i).getPosicion().getX();
			esquinaJugador1[i][1] = unidades1.get(i).getPosicion().getY();
			
			esquinaJugador2[i][0] = unidades1.get(i).getPosicion().getX();
			esquinaJugador2[i][1] = unidades1.get(i).getPosicion().getY();
		}
			
		if( esquinasSonIguales(esquinaJugador1,esquinaSuperiorIzq))
			assertTrue(esquinasSonIguales(esquinaJugador2,esquinaInferiorDer));
	
		if( esquinasSonIguales(esquinaJugador1,esquinaSuperiorDer) )
			assertTrue(esquinasSonIguales(esquinaJugador2,esquinaInferiorIzq));
		    
		if( esquinasSonIguales(esquinaJugador1,esquinaInferiorIzq) )
			assertTrue(esquinasSonIguales(esquinaJugador2,esquinaSuperiorDer));
		    
		if( esquinasSonIguales(esquinaJugador1,esquinaInferiorDer) )
			assertTrue(esquinasSonIguales(esquinaJugador2,esquinaSuperiorIzq));
		*/
	}
	
	private boolean esquinasSonIguales(int[][] esquina1,int[][] esquina2){
		int i;
		
		for(i=0; i < 3; i++){
			for(int k=0;k < 3;k++)
		        if( esquina1[i][0] == esquina2[k][0])
		        	if(esquina1[i][0] == esquina2[k][1])
			            i++;
		}	
		return i==3;//las tres posiciones son iguales
   }
}
