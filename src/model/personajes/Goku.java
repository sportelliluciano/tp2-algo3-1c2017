package model.personajes;

import model.Tablero;
import model.Unidad;
import model.ataque.Ataque;
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
	public void recibirAtaque(Ataque ataque) {
		vida.reducirEn(ataque.getDano());
		if (vida.getPorcentajeVida() < 30)
			modo.incrementarPoderPelea(1.2);
	}
	
	public void ataqueEspecialA(Unidad unidad, Tablero tablero) throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente ,ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida {
		_atacar(unidad, tablero, new Kamehameha(estado.aplicarBoost(modo.getPoderDeAtaque())));
	}
}
