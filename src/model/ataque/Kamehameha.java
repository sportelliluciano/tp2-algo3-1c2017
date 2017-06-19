package model.ataque;


public class Kamehameha extends AtaqueBasico implements Ataque {
	
	public Kamehameha(int danoBasico) {
		super((int)(danoBasico * 1.5));
	}

}
