package model.equipos;

import java.util.ArrayList;

import model.Equipo;
import model.Unidad;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class GuerrerosZ extends Equipo {

	private Gohan gohan;
	private Goku goku;
	private Piccolo piccolo;
	
	public GuerrerosZ() {
		integrantes = new ArrayList<Unidad>();
		goku = new Goku(this);
		gohan = new Gohan(this);
		piccolo = new Piccolo(this);
		integrantes.add(gohan);
		integrantes.add(goku);
		integrantes.add(piccolo);
		nombreEquipo = "Guerreros Z";
	}

	public Goku getGoku() {
		return goku;
	}
	
	public Gohan getGohan() {
		return gohan;
	}
	
	public Piccolo getPiccolo() {
		return piccolo;
	}
}
