package model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private int jugadorActual;
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		tablero = new Tablero(15, 10);
		tablero.agregarEquipos(jugador1.equipo(), jugador2.equipo());
		jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadorActual = ((int)(Math.random() * 100)) % 2;
	}
	
	private void agregarConsumibles() {
		if ( (Math.random() * 100) < 50 )
			tablero.agregarConsumibleAleatorio();
	}
	
	public Jugador siguienteTurno() {
		jugadores.get(jugadorActual).pasarTurno();
		
		agregarConsumibles();
		
		jugadorActual = (jugadorActual + 1) % 2;
		return jugadores.get(jugadorActual);
	}
	

	public Tablero getTablero() {
		return tablero;
	}

}


