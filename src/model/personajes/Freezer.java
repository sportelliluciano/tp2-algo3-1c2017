package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.RayoMortal;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.FreezerNormal;

public class Freezer extends Unidad {

	public Freezer(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		this.vida = new Vida(400);
		
		modo = new FreezerNormal();
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new RayoMortal(estado.aplicarBoost(modo.getPoderDeAtaque())));
	}

}
