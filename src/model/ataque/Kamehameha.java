package model.ataque;


public class Kamehameha extends AtaqueBasico implements Ataque {
	
	public Kamehameha(int poderDePelea) {
		this.poderDePelea = poderDePelea;
		this.dano = (int)(poderDePelea * 1.5);
	}

}
