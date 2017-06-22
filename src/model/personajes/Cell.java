package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.ataque.Kamehameha;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.CellNormal;

public class Cell extends Unidad {
	int vidaAbsorbida;
	
	public Cell(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		vida = new Vida(500);
		vidaAbsorbida = 0;
		modo = new CellNormal();
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) 
			throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		super.validarAtaque(unidad, tablero);
		ki.reducirEn(5);
		Ataque ataque = new AtaqueBasico(estado.aplicarBoost(modo.getPoderDeAtaque()));
		vidaAbsorbida++;
		vida.incrementarEn(ataque.getDano());
		_atacar(unidad, tablero, ataque);
	}
	
	
	
}
