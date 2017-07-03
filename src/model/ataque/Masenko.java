package model.ataque;

public class Masenko extends AtaqueBasico implements Ataque {

	public Masenko(int poderDePelea) {
		this.poderDePelea = poderDePelea;
		this.dano = (int)(poderDePelea * 1.25);
	}
}
