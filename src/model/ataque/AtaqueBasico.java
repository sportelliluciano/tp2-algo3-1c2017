package model.ataque;

public class AtaqueBasico implements Ataque {

	private int dano;
	
	public AtaqueBasico(int dano) {
		this.dano = dano;
	}
	
	@Override
	public int getDano() {
		return this.dano;
	}
}
