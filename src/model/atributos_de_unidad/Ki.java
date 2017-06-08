package model.atributos_de_unidad;

public class Ki {

	private static final int INCREMENTO_POR_TURNO = 5;
	private int magnitud = 0;

	public void reducirEn(int magnitud) {
		// TODO Auto-generated method stub
		if (this.magnitud < magnitud)
			//TODO: Exception
			throw new RuntimeException();
		this.magnitud -= magnitud;
	}

	public int getMagnitud() {
		return magnitud;
	}

	public void pasarTurno() {
		this.magnitud += INCREMENTO_POR_TURNO;
	}

}
