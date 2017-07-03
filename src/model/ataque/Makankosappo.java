package model.ataque;

public class Makankosappo extends AtaqueBasico implements Ataque {

	public Makankosappo(int poderDePelea) {
		this.poderDePelea = poderDePelea;
		this.dano = (int)(poderDePelea * 1.25);
	}

}
