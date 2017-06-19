package integration.consignas_semana_1;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.Juego;
import model.Jugador;
import model.Posicion;
import model.Tablero;
import model.error.ErrorPosicionInvalida;
import model.personajes.Cell;
import model.personajes.Freezer;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.MajinBoo;
import model.personajes.Piccolo;
	
//No se si esta del todo bien,pero lo pongo para ver si sirve,faltaria el elegir unidades
//en jugador para que pueda devolverlas y asi poder saber las posiciones 
public class TestSemana1Consigna06 {	
	@Test
	public void test06CrearJuegoYValidarPosicionesDeTablero() throws ErrorPosicionInvalida {		
		Jugador jugador1,jugador2;
		jugador1 = new Jugador("Fabio");
		jugador2 = new Jugador("Marito");

		Juego juego = new Juego(jugador1, jugador2);
		
		jugador1.setJuego(juego,null);//como es el jugador 1 no tiene esquina rival,entonces paso null
		jugador2.setJuego(juego,jugador1.getEsquina());
		
		Tablero tablero = juego.getTablero();
		
		int alto = tablero.getAlto();
		int ancho = tablero.getAncho();
		
		jugador1.elegirPersonaje(new Gohan());
		jugador1.elegirPersonaje(new Goku());
		jugador1.elegirPersonaje(new Piccolo());

		jugador2.elegirPersonaje(new Freezer());
		jugador2.elegirPersonaje(new Cell());
		jugador2.elegirPersonaje(new MajinBoo());

		Set<Posicion> esquina1 = jugador1.getEsquina();
		
		Set<Posicion> esquina2 = jugador2.getEsquina();
		
		//preparo las esquinas del tablero para poder compararlas con las de los jugadores
		
        Set<Posicion> esquinaSuperiorIzq = new HashSet<Posicion>();
		
		esquinaSuperiorIzq.add(new Posicion(0,0));
		esquinaSuperiorIzq.add(new Posicion(1,0));
		esquinaSuperiorIzq.add(new Posicion(0,1));
		
		Set<Posicion> esquinaSuperiorDer= new HashSet<Posicion>();
		
		esquinaSuperiorDer.add(new Posicion(0,alto));
		esquinaSuperiorDer.add(new Posicion(1,alto));
		esquinaSuperiorDer.add(new Posicion(0,alto - 1));
		
		Set<Posicion> esquinaInferiorDer = new HashSet<Posicion>();

		esquinaInferiorDer.add(new Posicion(ancho,alto - 1));
		esquinaInferiorDer.add(new Posicion(ancho - 1,alto));
		esquinaInferiorDer.add(new Posicion(ancho,alto));

		Set<Posicion> esquinaInferiorIzq = new HashSet<Posicion>();

		esquinaInferiorIzq.add(new Posicion(ancho,0));
		esquinaInferiorIzq.add(new Posicion(ancho,1));
		esquinaInferiorIzq.add(new Posicion(ancho - 1,0));

	//comparo que cada jugador tenga su esquina y q el otro la opuesta
		
		if( esquina1.containsAll(esquinaSuperiorIzq))
			assertTrue(esquina2.containsAll(esquinaInferiorDer));
		else
		if( esquina1.containsAll(esquinaSuperiorDer) )
			assertTrue(esquina2.containsAll(esquinaInferiorIzq));
		else    
		if( esquina1.containsAll(esquinaInferiorIzq) )
			assertTrue(esquina2.containsAll(esquinaSuperiorDer));
		else    
		if( esquina1.containsAll(esquinaInferiorDer) )
			assertTrue(esquina2.containsAll(esquinaSuperiorIzq));
		
	}

}
