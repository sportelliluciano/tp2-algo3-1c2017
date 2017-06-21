package model.ataque;

import java.util.ArrayList;

import model.efectos.Efecto;

public class AtaqueBasico implements Ataque {

	private int dano;
	
	public AtaqueBasico(int dano) {
		this.dano = dano;
	}
	
	@Override
	public int getDano() {
		return this.dano;
	}

	@Override
	public int paralizaDurante() {
		return 0;
	}

	@Override
	public ArrayList<Efecto> efectos() {
		// TODO Auto-generated method stub
		return new ArrayList<Efecto>();
	}
}
