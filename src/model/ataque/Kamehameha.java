package model.ataque;


public class Kamehameha implements Ataque {

	private int dano;
	
	public Kamehameha(int danoBasico) {
		this.dano = (int)(danoBasico * 1.5);
	}
	
	@Override
	public int getDano() {
		return this.dano;
	}

}
