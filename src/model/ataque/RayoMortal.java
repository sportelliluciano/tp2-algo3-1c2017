package model.ataque;

public class RayoMortal extends AtaqueBasico implements Ataque {
	public RayoMortal(int poderPelea) {
		super((int)(poderPelea * 1.5));
	}
}
