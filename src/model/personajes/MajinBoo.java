package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.ConvierteteEnChocolate;
import model.atributos_de_unidad.Vida;
import model.equipos.EnemigosDeLaTierra;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.MajinBooNormal;

public class MajinBoo extends Unidad {

	public MajinBoo(EnemigosDeLaTierra equipo) {
		this.equipo = equipo;
		this.vida = new Vida(300);
		
		modo = new MajinBooNormal();
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new ConvierteteEnChocolate());
	}

}
