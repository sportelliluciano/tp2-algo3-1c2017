package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.AtaqueBasico;
import model.ataque.Kamehameha;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.GokuNormal;

public class Goku extends Unidad {
	
	public Goku(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(500);
		
		modo = new GokuNormal();
	}
	
	@Override
	public void ataqueBasicoA(Unidad unidad, Tablero tablero) 
			throws ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new AtaqueBasico(estado.aplicarBoost(getPoderDePelea())));
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) 
			throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new Kamehameha(estado.aplicarBoost(getPoderDePelea())));
	}
	
	private int getPoderDePelea() {
		if (vida.getPorcentajeVida() < 30)
			return (int)(modo.getPoderDeAtaque() * 1.2);
		return modo.getPoderDeAtaque();
	}
}
