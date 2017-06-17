package model.personajes;

import model.Unidad;
import model.ataque.Ataque;
import model.error.ErrorKiInsuficiente;
import model.personajes.modos.GokuNormal;

public class Goku extends Unidad {

	public Goku() {
		vidaMaxima = 500;
		vidaActual = 500;
		modo = new GokuNormal();
	}

	@Override
	public void ataqueBasicoA(Unidad unidad) {
		Ataque ataqueBasico = modo.getAtaqueBasico();
		unidad.recibirAtaque(ataqueBasico);
	}

	@Override
	public void ataqueEspecialA(Unidad unidad) throws ErrorKiInsuficiente {
		Ataque kamehameha = modo.getAtaqueEspecial();
		unidad.recibirAtaque(kamehameha);
	}
	
	@Override
	public void recibirAtaque(Ataque ataque) {
		this.vidaActual -= ataque.getDano();
	}
}
