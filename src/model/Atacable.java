package model;

import model.ataque.Ataque;
import model.atributos_de_unidad.Modo;

public interface Atacable {
	public Ataque getAtaqueBasico(Modo modo);
	public Ataque getAtaqueEspecial(Modo modo);
	public void recibirAtaque(Unidad unidad, Ataque ataque);
}
