package model.personajes;

import model.Unidad;
import model.equipos.EnemigosDeLaTierra;
import model.personajes.modos.CellNormal;

public class Cell extends Unidad {
	int vidaAbsorbida;
	
	public Cell(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;

		modo = new CellNormal();
	}
}
