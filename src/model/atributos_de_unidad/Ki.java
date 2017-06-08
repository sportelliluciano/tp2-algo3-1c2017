package model.atributos_de_unidad;

public class Ki {

	private int magnitud;

	public void reducirEn(int magnitud) {
		// TODO Auto-generated method stub
		if (this.magnitud < magnitud)
			//TODO: Exception
			throw new RuntimeException();
	}

	public int getMagnitud() {
		return magnitud;
	}

}
