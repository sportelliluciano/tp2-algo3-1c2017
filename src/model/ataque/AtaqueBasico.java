package model.ataque;

import java.util.ArrayList;

import model.efectos.Efecto;

public class AtaqueBasico implements Ataque {

	protected int poderDePelea;
	protected int dano;
	
	public AtaqueBasico() {
		dano = 0;
		poderDePelea = 0;
	}
	
	public AtaqueBasico(int poderDePelea) {
		this.dano = poderDePelea;
		this.poderDePelea = poderDePelea;
	}
	
	@Override
	public int getDano(int poderDePeleaPropio) {
		if (poderDePeleaPropio > poderDePelea)
			return (int)(this.dano * 0.8);
		return this.dano;
	}

	@Override
	public ArrayList<Efecto> efectos() {
		return new ArrayList<Efecto>();
	}
}
