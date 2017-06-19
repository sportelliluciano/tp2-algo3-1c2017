package model;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import model.error.ErrorPosicionInvalida;

public class Jugador {
		
	private String nombre;
	
	private Juego juego;
	
	private Set<Posicion> esquina = null;
	
	private Set<Unidad> personajes;

	public Jugador(String nombre) {
		this.nombre = nombre;
		personajes = new HashSet<Unidad>();//guarda una referencia de las unidades agregadas al tablero

	}

	public void setJuego(Juego juego,Set<Posicion> esquinaEnemiga){
		this.juego = juego;
		esquina = esquinaAleatoria(esquinaEnemiga);
	}
	
	public void elegirPersonaje(Unidad unidad) throws ErrorPosicionInvalida{
		Posicion pos = posEsquina(esquina);
		juego.agregarUnidad(unidad, pos);
		personajes.add(unidad);
	}
	
	private Posicion posEsquina(Set<Posicion> posiciones){
		Iterator<Posicion> iterador = posiciones.iterator();
		Posicion pos = null;
		
		if(iterador.hasNext()){
			pos = iterador.next();
			iterador.remove();
		}
		
	    return pos;		
	}
	
	private Set<Posicion> esquinaAleatoria(Set<Posicion> esquinaEnemiga){
		
		int ancho = juego.getTablero().getAncho();
		int alto = juego.getTablero().getAlto();
		
		//preparo las esquinas del tablero
		
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
		
		if (esquinaEnemiga != null){//si el jugador opuesto ya eligio,entonces debo tener la esquina opuesta
		    if (esquinaEnemiga.containsAll(esquinaSuperiorIzq)) return esquinaInferiorDer;
		    if (esquinaEnemiga.containsAll(esquinaSuperiorDer)) return esquinaInferiorIzq;
		    if (esquinaEnemiga.containsAll(esquinaInferiorIzq)) return esquinaSuperiorDer;
		    if (esquinaEnemiga.containsAll(esquinaInferiorDer)) return esquinaSuperiorIzq;
		}
		
		//en caso de ser el primer jugador en elejir,se escoge una de las 4 esquinas de forma aleatoria
		switch((int) (Math.random() * 4) + 1) {
		
		case 1:return esquinaSuperiorDer;
		case 2:return esquinaSuperiorIzq;
		case 3:return esquinaInferiorDer;
		case 4:return esquinaInferiorIzq;
		
		}
		return null;

	}

	public Set<Unidad> getPersonajes() {
		return personajes;
	}

	public Set<Posicion> getEsquina() {
		return esquina;
	}
	
	
	
}

