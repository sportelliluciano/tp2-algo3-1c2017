package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.Ataque;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.CellNormal;

public class Cell extends Unidad {

	public Cell(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		vida = new Vida(500);
		
		modo = new CellNormal();
	}
	
	@Override
	public void ataqueEspecialA(Unidad unidad, Tablero tablero)
			throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		Ataque ataqueEspecial = this.modo.getAtaqueEspecial();
		this.vida.incrementarEn(ataqueEspecial.getDano());
		super._atacar(unidad, tablero, ataqueEspecial);
	}
}
