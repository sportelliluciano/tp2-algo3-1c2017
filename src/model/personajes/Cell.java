package model.personajes;

import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.CellNormal;

public class Cell extends Unidad {

	public Cell(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		vidaMaxima = 500;
		vidaActual = 500;
		
		modo = new CellNormal();
	}
}
