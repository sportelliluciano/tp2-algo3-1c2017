package model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private Tablero tablero;
	private List<Jugador> jugadores;
	private int jugadorActual;
	private Notificable<Jugador> onJuegoTerminado;
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		
		jugador1.setJuego(this);
		jugador2.setJuego(this);
		
		tablero = new Tablero(15, 10);
		tablero.agregarEquipos(jugador1.equipo(), jugador2.equipo());
		jugadores = new ArrayList<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		jugadorActual = ((int)(Math.random() * 100)) % 2;
		onJuegoTerminado = new Notificable<Jugador>() {
			public void notificar(Jugador j) {
				throw new ErrorJuegoTerminado();
			}
		};
	}
	
	private void agregarConsumibles() {
		if ( (Math.random() * 100) < 50 )
			tablero.agregarConsumibleAleatorio();
	}
	
	public Jugador siguienteTurno() {
		verificarFinalDelJuego();
		jugadores.get(jugadorActual).pasarTurno();
		
		agregarConsumibles();
		
		jugadorActual = (jugadorActual + 1) % 2;
		return jugadores.get(jugadorActual);
	}
	
	private void verificarFinalDelJuego() {
		int i=0;
		while (i < jugadores.size()) {
			Jugador jugador = jugadores.get(i);
			if (jugador.equipo().cantidadDeEsferasDelDragon() == 7) 
				onJuegoTerminado.notificar(jugador);
			
			if (!jugador.equipo().estaVivo()) {
				jugadores.remove(i);
				continue;
			}
			
			i++;
		}
		
		if (jugadores.size() == 1)
			onJuegoTerminado.notificar(jugadores.get(0));
		if (jugadores.size() == 0)
			throw new ErrorJuegoTerminado();
	}

	public Tablero getTablero() {
		return tablero;
	}

	public Jugador getJugadorActual() {
		return jugadores.get(jugadorActual);
	}

	public List<Jugador> jugadores() {
		return jugadores;
	}

	public void setOnJuegoTerminado(Notificable<Jugador> notificable) {
		onJuegoTerminado = notificable;
	}

}


