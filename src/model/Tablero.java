package model;

import java.util.List;

import model.consumibles.EsferaDelDragon;
import model.consumibles.NubeVoladora;
import model.consumibles.Semilla;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadParalizada;

import java.util.ArrayList;

public class Tablero {
	private List<Posicionable> posicionables = new ArrayList<Posicionable>();
	private int alto;
	private int ancho;
	
	public Tablero (int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
		
		if ( (alto < 3) || (ancho < 3) )
			throw new RuntimeException();
	}
	
	public boolean hayPosicionableEn(Posicion pos) {
		for (Posicionable p: posicionables) {
			if (p.getPosicion().equals(pos))
				return true;
		}
		
		return false;
	}

	public void agregarPosicionable(Posicionable posicionable, Posicion posicion) throws ErrorPosicionInvalida {
		validarPosicion(posicion);
		if (hayPosicionableEn(posicion))
			throw new ErrorPosicionInvalida();
		
		posicionable.setPosicion(posicion);
		posicionables.add(posicionable);
	}

	public void moverUnidad(Unidad unidad, Posicion nuevaPosicion) throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		validarPosicion(nuevaPosicion);
		unidad.moverA(nuevaPosicion, this);
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
		esquinaSupIzq.add(new Posicion(0,0));
		esquinaSupIzq.add(new Posicion(0,1));
		esquinaSupIzq.add(new Posicion(1,0));
		List<Posicion> esquinaInfDer = new ArrayList<Posicion>();
		esquinaInfDer.add(new Posicion(ancho-1,alto-1));
		esquinaInfDer.add(new Posicion(ancho-1,alto-2));
		esquinaInfDer.add(new Posicion(ancho-2,alto-1));
		
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
		int x = ((int)Math.random() * 100000) % ancho;
		int y = ((int)Math.random() * 100000) % alto;
		
		return new Posicion(x, y);
	}
	
	public void agregarConsumibleAleatorio() {
		Consumible consumible = null;
		int opc = ((int)(Math.random() * 100)) % 3;
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
	
}
