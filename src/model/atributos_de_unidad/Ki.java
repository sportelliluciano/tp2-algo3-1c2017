package model.atributos_de_unidad;

import model.error.ErrorKiInsuficiente;

public class Ki {

	private static final int INCREMENTO_POR_TURNO = 5;
	private int magnitud = 0;

	public void reducirEn(int magnitud) throws ErrorKiInsuficiente {
		if (this.magnitud < magnitud)
			throw new ErrorKiInsuficiente();
		this.magnitud -= magnitud;
	}

	public int getMagnitud() {
		return magnitud;
	}

	public void pasarTurno() {
		this.magnitud += INCREMENTO_POR_TURNO;
	}

}
