package model;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> f4386a9333726fef5eff9d640110441ba2a07909

import model.error.ErrorPosicionInvalida;

// La posicion (i,j) en el tablero de un consumible / unidad.
// Podriamos heredar de alguna de java pero javafx.Point2D labura con doubles
// Hay un Point de ints pero en awt; es una libreria obsoleta, mejor no usarla.
public class Posicion {
	private int x,y;
	
	public Posicion(int x, int y) throws ErrorPosicionInvalida {
		if ((x < 0) || (y < 0))
			throw new ErrorPosicionInvalida();
		
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Posicion other) {
		return (this.x == other.x && this.y == other.y);
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
<<<<<<< HEAD

	public boolean estaDentroDelLimite(int limiteX, int limiteY) {
		return (this.x < limiteX) && (this.y < limiteY);
	}
	
=======
	
	public ArrayList<Posicion> getVecinos() {
		ArrayList<Posicion> lista =  new ArrayList<Posicion>();
		
		try {
			lista.add(new Posicion(Math.max(i-1,0), Math.max(j-1, 0)));
			lista.add(new Posicion(Math.max(i-1,0), j));
			lista.add(new Posicion(Math.max(i-1,0), j+1));
			
			lista.add(new Posicion(i, j+1));
			lista.add(new Posicion(i, Math.max(j-1, 0)));
			
			lista.add(new Posicion(i+1, Math.max(j-1, 0)));
			lista.add(new Posicion(i+1, j));
			lista.add(new Posicion(i+1, j+1));
			
		} catch (ErrorPosicionInvalida e) {	}
		
		return lista;
		
	}
>>>>>>> f4386a9333726fef5eff9d640110441ba2a07909
}
