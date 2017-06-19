package model.equipos;

import java.util.ArrayList;


import model.Equipo;
import model.Unidad;
import model.personajes.Cell;
import model.personajes.Freezer;
import model.personajes.MajinBoo;

public class EnemigosDeLaTierra extends Equipo {
	private Cell cell;
	private Freezer freezer;
	private MajinBoo majinboo;
	
	public EnemigosDeLaTierra() {
		integrantes = new ArrayList<Unidad>();
		cell = new Cell(this);
		freezer = new Freezer(this);
		majinboo = new MajinBoo(this);
		integrantes.add(cell);
		integrantes.add(freezer);
		integrantes.add(majinboo);
	}

	public Cell getCell() {
		return cell;
	}
	
	public Freezer getFreezer() {
		return freezer;
	}
	
	public MajinBoo getMajinBoo() {
		return majinboo;
	}
}
