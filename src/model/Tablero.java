package model;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import model.consumibles.ConsumibleVacio;
import model.consumibles.EsferaDelDragon;
import model.consumibles.NubeVoladora;
import model.consumibles.Semilla;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoSePuedePisar;
import model.error.ErrorUnidadParalizada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Tablero {
	private Map<Posicion, Posicionable> posicionables = new HashMap<Posicion, Posicionable>();
	private int alto;
	private int ancho;
	
	final private int ANCHO_MIN = 4;
	final private int ALTO_MIN  = 3;
	
	public Tablero (int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
		
		if ( (alto < ALTO_MIN) || (ancho < ANCHO_MIN) )
			throw new RuntimeException("El tablero debe ser como mínimo de " + ANCHO_MIN + "x" + ALTO_MIN);
	}
	
	public boolean hayPosicionableEn(Posicion pos) {
		return posicionables.containsKey(pos);
	}

	public void agregarPosicionable(Posicionable posicionable, Posicion posicion) throws ErrorPosicionInvalida {
		validarPosicion(posicion);
	
		if (posicionables.putIfAbsent(posicion, posicionable) != null)
			throw new ErrorPosicionInvalida();
		
		posicionable.setPosicion(posicion);
	}

	private void _calcularMovimientosPosibles(Set<Posicion> posibles, Posicion posicion, int maxPasos) {
		if (maxPasos <= 0) return;
		
		for (Posicion p: posicion.getVecinos(Direccion.getDireccionesSinDiagonales())) {
			if ( (!hayPosicionableEn(p)) && (!p.equals(posicion)) ) {
				posibles.add(p);
				_calcularMovimientosPosibles(posibles, p, maxPasos - 1);
			}
		}
	}
	
	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		if (!puedeLlegarA(nuevaPosicion, unidad.getPosicion(), unidad.getVelocidad()))
			throw new ErrorPosicionInvalida();
		try {
			Consumible consumible = pisar(nuevaPosicion);
			posicionables.remove(unidad.getPosicion());
			posicionables.put(nuevaPosicion, unidad);
			unidad.moverA(nuevaPosicion, consumible);
		}
		catch (ErrorUnidadNoSePuedePisar e) {
			throw new ErrorPosicionInvalida();
		}
	}
	
	private Consumible pisar(Posicion posicion) throws ErrorUnidadNoSePuedePisar {
		return posicionables.getOrDefault(posicion, new ConsumibleVacio()).pisar();
	}
	
	public void cambiarPosUnidad(Unidad u, Posicion p) {
		Posicion posAnterior = null;
		for (Posicion pos : posicionables.keySet()) {
			if (posicionables.get(pos).equals(u)) {
				posAnterior = pos;
				break;
			}
		}
		if (posAnterior == null)
			throw new RuntimeException("Esto no debería pasar");
		posicionables.remove(posAnterior);
		posicionables.put(p, u);
	}
	
	public Set<Posicion> getMovimientosPosibles(Posicion origen, int velocidad) {
		Set<Posicion> resultado = new HashSet<Posicion>();
		_calcularMovimientosPosibles(resultado, origen, velocidad);
		return resultado;
	}
	
	private boolean buscarDestino(Posicion origen, Posicion destino, int distanciaMax) {
		if (origen.equals(destino))
			return true;
		
		if (distanciaMax <= 0) 
			return false;
		
		for (Posicion p: origen.getVecinos(Direccion.getDireccionesSinDiagonales())) {
			if (p.equals(destino))
				return true;
			if (buscarDestino(p, destino, distanciaMax - 1))
				return true;
		}
		
		return false;
	}
	
	public boolean estaDentroDelAlcance(Posicion origen, Posicion destino, int distanciaMax) {
		return buscarDestino(origen, destino, distanciaMax);
	}
	
	public void validarPosicion(Posicion posicion) throws ErrorPosicionInvalida {
		if ( (posicion.getX() < 0) || (posicion.getY() < 0) )
			throw new ErrorPosicionInvalida();
		if ( (posicion.getX() > this.ancho) || (posicion.getY() > this.alto) )
			throw new ErrorPosicionInvalida();
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}

	public void agregarEquipos(Equipo equipo1, Equipo equipo2) {
		List<Posicion> esquinaSupIzq = new ArrayList<Posicion>();
		esquinaSupIzq.add(new Posicion(2,0));
		esquinaSupIzq.add(new Posicion(0,2));
		esquinaSupIzq.add(new Posicion(1,1));
		List<Posicion> esquinaInfDer = new ArrayList<Posicion>();
		esquinaInfDer.add(new Posicion(ancho-3,alto-1));
		esquinaInfDer.add(new Posicion(ancho-1,alto-3));
		esquinaInfDer.add(new Posicion(ancho-2,alto-2));
		
		try {
			int i = 0;
			for (Unidad integrante : equipo1.integrantes()) {
				agregarPosicionable(integrante, esquinaSupIzq.get(i));
				i++;
			}
			i = 0;
			for (Unidad integrante : equipo2.integrantes()) {
				agregarPosicionable(integrante, esquinaInfDer.get(i));
				i++;
			}
		}
		catch (ErrorPosicionInvalida e) {
			throw new RuntimeException(e);
		}
	}

	private Posicion getPosicionRandom() {
		Random rand = new Random();
		int x = rand.nextInt() % ancho;
		int y = rand.nextInt() % alto;
		
		return new Posicion(x, y);
	}
	
	public void agregarConsumibleAleatorio() {
		Consumible consumible = null;
		Random rand = new Random();
		int opc = Math.abs(rand.nextInt()) % 3;
		switch(opc) {
		case 0:
			consumible = new Semilla();
			break;
		case 1:
			consumible = new EsferaDelDragon();
			break;
		case 2:
			consumible = new NubeVoladora();
			break;
		}
		
		Posicion p = getPosicionRandom();
		try {
			agregarPosicionable(consumible, p);
		} catch (ErrorPosicionInvalida e) {
			return;
		}
	}

	public Posicionable getPosicionable(int i, int j) {
		return posicionables.get(new Posicion(i, j));
	}

	public void eliminarPosicionable(Posicion pos) {
		posicionables.remove(pos);
	}

	public boolean puedeLlegarA(Posicion nuevaPosicion, Posicion origen, int velocidad) {
		if (origen.equals(nuevaPosicion))
			return true;
		
		if (velocidad <= 0) 
			return false;
		
		for (Posicion p: origen.getVecinos(Direccion.getDireccionesSinDiagonales())) {
			if (p.equals(nuevaPosicion))
				return true;
			
			if (hayPosicionableEn(p))
				continue;
			
			if (puedeLlegarA(nuevaPosicion, p, velocidad - 1))
				return true;
		}
		
		return false;
	}
	
}
