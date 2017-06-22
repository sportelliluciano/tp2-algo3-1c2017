package integration.consignas_semana_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import model.Juego;
import model.Jugador;
import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorPosicionInvalida;
	
//No se si esta del todo bien,pero lo pongo para ver si sirve,faltaria el elegir unidades
//en jugador para que pueda devolverlas y asi poder saber las posiciones 
public class TestSemana1Consigna06 {	
	@Test
	public void test06CrearJuegoYValidarPosicionesDeTablero() throws ErrorPosicionInvalida {		
		Jugador jugador1,jugador2;
		jugador1 = new Jugador("Fabio", new EnemigosDeLaTierra());
		jugador2 = new Jugador("Marito", new GuerrerosZ());

		Juego juego = new Juego(jugador1, jugador2);
		
		Tablero tablero = juego.getTablero();
		
		int alto = tablero.getAlto();
		int ancho = tablero.getAncho();
		
		Set<Posicion> posicionesJ1 = new HashSet<Posicion>();
		
		for(Unidad integrante : jugador1.getPersonajes()) {
			posicionesJ1.add(integrante.getPosicion());
		}
		
		assertEquals(3, posicionesJ1.size());
		assertTrue(posicionesJ1.contains(new Posicion(0,0)));
		assertTrue(posicionesJ1.contains(new Posicion(0,1)));
		assertTrue(posicionesJ1.contains(new Posicion(1,0)));
		
		Set<Posicion> posicionesJ2 = new HashSet<Posicion>();
		
		for(Unidad integrante : jugador2.getPersonajes()) {
			posicionesJ2.add(integrante.getPosicion());
		}
		
		assertEquals(3, posicionesJ2.size());
		assertTrue(posicionesJ2.contains(new Posicion(ancho-1, alto-1)));
		assertTrue(posicionesJ2.contains(new Posicion(ancho-2, alto-1)));
		assertTrue(posicionesJ2.contains(new Posicion(ancho-1, alto-2)));
	}

}
