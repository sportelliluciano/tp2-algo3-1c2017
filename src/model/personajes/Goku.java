package model.personajes;

import model.Unidad;
import model.ataque.Ataque;
import model.atributos_de_unidad.Vida;
import model.equipos.GuerrerosZ;
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
}
