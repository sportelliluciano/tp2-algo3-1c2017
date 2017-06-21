package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.Makankosappo;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.PiccoloNormal;

public class Piccolo extends Unidad {
	
	public Piccolo(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(500);
		
		modo = new PiccoloNormal(equipo);
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new Makankosappo(estado.aplicarBoost(modo.getPoderDeAtaque())));
	}

}
