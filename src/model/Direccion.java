package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Direccion {
	
    public static Direccion DERECHA;
    public static Direccion ARRIBA_DERECHA;
    public static Direccion ARRIBA;
    public static Direccion ARRIBA_IZQUIERDA;
    public static Direccion IZQUIERDA;
    public static Direccion ABAJO_IZQUIERDA;
    public static Direccion ABAJO;
    public static Direccion ABAJO_DERECHA;
    public static Direccion SIN_MOVIMIENTO;
    
    // Inspirado levemente en codigo propuesto en la teorica.
	static {
		DERECHA = 			new Direccion( 1,  0);
		ARRIBA_DERECHA = 	new Direccion( 1,  1);
		ARRIBA =	 		new Direccion( 0, -1);
		ARRIBA_IZQUIERDA = 	new Direccion(-1,  1);
		IZQUIERDA = 		new Direccion(-1,  0);
		ABAJO_IZQUIERDA = 	new Direccion(-1, -1);
		ABAJO = 			new Direccion( 0,  1);
		ABAJO_DERECHA = 	new Direccion( 1, -1);
		SIN_MOVIMIENTO =    new Direccion( 0,  0);
    }
	
	private static ArrayList<Direccion> sinDiagonales = new ArrayList<Direccion>(Arrays.asList(DERECHA, ARRIBA, IZQUIERDA, ABAJO));
	private static ArrayList<Direccion> conDiagonales = new ArrayList<Direccion>(Arrays.asList(DERECHA, ARRIBA_DERECHA, ARRIBA, ARRIBA_IZQUIERDA, IZQUIERDA, ABAJO_IZQUIERDA, ABAJO, ABAJO_DERECHA));
	
    private int x;
    private int y;

	public static ArrayList<Direccion> getDireccionesConDiagonales() {
		return conDiagonales;
	}
	
	public static ArrayList<Direccion> getDireccionesSinDiagonales() {
		return sinDiagonales;
	}
	
    private Direccion(int x, int y) {
        this.x = x;
        this.y = y;
    }

	public Posicion obtenerPosicionNueva(Posicion actual) {
		return actual.add(new Posicion(x, y));
	}
}