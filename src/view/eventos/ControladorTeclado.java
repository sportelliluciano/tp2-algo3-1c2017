package view.eventos;

import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Direccion;
import model.Juego;
import model.Jugador;
import model.Posicion;
import view.ContenedorJuego;

public class ControladorTeclado implements EventHandler<KeyEvent> {

	private ContenedorJuego contenedorJuego;
	private Juego juego;
	private Map<Jugador, Map<KeyCode,KeyCode>> teclas;
	
	private static Map<KeyCode, KeyCode> teclasJ1;
	private static Map<KeyCode, KeyCode> teclasJ2;
	
	static {
		teclasJ1 = new HashMap<KeyCode,KeyCode>();
		teclasJ2 = new HashMap<KeyCode,KeyCode>();
		/* Movimiento */
		teclasJ1.put(KeyCode.W, KeyCode.UP);
		teclasJ1.put(KeyCode.A, KeyCode.LEFT);
		teclasJ1.put(KeyCode.S, KeyCode.DOWN);
		teclasJ1.put(KeyCode.D, KeyCode.RIGHT);
		teclasJ2.put(KeyCode.UP, KeyCode.UP);
		teclasJ2.put(KeyCode.LEFT, KeyCode.LEFT);
		teclasJ2.put(KeyCode.DOWN, KeyCode.DOWN);
		teclasJ2.put(KeyCode.RIGHT, KeyCode.RIGHT);
		
		/* Acción */
		teclasJ1.put(KeyCode.Z, KeyCode.Z); // Transformar
		teclasJ1.put(KeyCode.X, KeyCode.X); // Mover/Atacar
		teclasJ1.put(KeyCode.C, KeyCode.C); // Ataque especial
		teclasJ2.put(KeyCode.U, KeyCode.Z); // Transformar
		teclasJ2.put(KeyCode.I, KeyCode.X); // Mover/Atacar
		teclasJ2.put(KeyCode.O, KeyCode.C); // Ataque especial
		
		/* Selección de personaje */
		teclasJ1.put(KeyCode.DIGIT1, KeyCode.DIGIT1);
		teclasJ1.put(KeyCode.DIGIT2, KeyCode.DIGIT2);
		teclasJ1.put(KeyCode.DIGIT3, KeyCode.DIGIT3);
		
		teclasJ2.put(KeyCode.DIGIT8, KeyCode.DIGIT1);
		teclasJ2.put(KeyCode.DIGIT9, KeyCode.DIGIT2);
		teclasJ2.put(KeyCode.DIGIT0, KeyCode.DIGIT3);
	}
	
	public ControladorTeclado(Juego juego, ContenedorJuego contenedorJuego) {
		this.contenedorJuego = contenedorJuego;
		this.juego = juego;
		teclas = new HashMap<Jugador, Map<KeyCode,KeyCode>>();
		teclas.put(juego.jugadores().get(0), teclasJ1);
		teclas.put(juego.jugadores().get(1), teclasJ2);
	}
	
	@Override
	public void handle(KeyEvent event) {
		handle_keymap(event, teclas.get(juego.getJugadorActual()));
	}

	private void handle_keymap(KeyEvent event, Map<KeyCode, KeyCode> keymap) {
		if (!keymap.containsKey(event.getCode()))
			return;
		
		Posicion posActual = contenedorJuego.getPosicionSeleccionada();
		if (posActual == null)
			posActual = contenedorJuego.getPosicionCentral();
		
		Direccion direccionMovimiento = Direccion.SIN_MOVIMIENTO;
		switch(keymap.get(event.getCode())) {
		case UP:
			direccionMovimiento = Direccion.ARRIBA;
			break;
		case DOWN:
			direccionMovimiento = Direccion.ABAJO;
			break;
		case LEFT:
			direccionMovimiento = Direccion.IZQUIERDA;
			break;
		case RIGHT:
			direccionMovimiento = Direccion.DERECHA;
			break;
		case DIGIT1:
			contenedorJuego.personajeSeleccionado(juego.getJugadorActual().getPersonajes().get(0));
			break;
		case DIGIT2:
			contenedorJuego.personajeSeleccionado(juego.getJugadorActual().getPersonajes().get(1));
			break;
		case DIGIT3:
			contenedorJuego.personajeSeleccionado(juego.getJugadorActual().getPersonajes().get(2));
			break;
		case Z: 
			contenedorJuego.clicTransformarse();
			break;
		case X:
			contenedorJuego.clicAccion();
			break;
		case C:
			contenedorJuego.clicAtaqueEspecial();
			break;
		case SPACE:
			contenedorJuego.clicPasarTurno();
		default:
			break;
		}
		
		contenedorJuego.seleccionarPosicion(direccionMovimiento.obtenerPosicionNueva(posActual));
		event.consume();
	}

}

