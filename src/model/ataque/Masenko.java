package model.ataque;

public class Masenko extends AtaqueBasico implements Ataque {

	public Masenko(int danoBasico) {
		super((int)(danoBasico * 1.25));
	}
}
