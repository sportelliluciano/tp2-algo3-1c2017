package model.ataque;

public class RayoMortal extends AtaqueBasico implements Ataque {
	public RayoMortal(int poderDePelea) {
		this.poderDePelea = poderDePelea;
		this.dano = (int)(poderDePelea * 1.5);
	}
}
