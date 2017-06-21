package model.personajes;


import model.Tablero;
import model.Unidad;
import model.ataque.Masenko;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.modos.GohanNormal;

public class Gohan extends Unidad {
	
	public Gohan(GuerrerosZ equipo) {
		this.equipo = equipo;
		this.vida = new Vida(300);
		
		modo = new GohanNormal(equipo);
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new Masenko(estado.aplicarBoost(modo.getPoderDeAtaque())));
	}

}
