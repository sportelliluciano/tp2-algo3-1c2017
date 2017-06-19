package model.ataque;

public class Makankosappo extends AtaqueBasico implements Ataque {

	public Makankosappo(int poderPelea) {
		super((int)(poderPelea * 1.25));
	}

}
