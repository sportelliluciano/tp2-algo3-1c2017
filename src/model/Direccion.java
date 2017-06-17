package model;

import java.util.ArrayList;
import java.util.Arrays;

import model.error.ErrorPosicionInvalida;

public class Direccion {
	
    private static Direccion der;
    private static Direccion arriba_der;
    private static Direccion arriba;
    private static Direccion arriba_izq;
    private static Direccion izq;
    private static Direccion abajo_izq;
    private static Direccion abajo;
    private static Direccion abajo_der;
    
    // Inspirado levemente en codigo propuesto en la teorica.
	static {
		der = 			new Direccion( 1,  0);
		arriba_der = 	new Direccion( 1,  1);
		arriba = 		new Direccion( 0,  1);
		arriba_izq = 	new Direccion(-1,  1);
		izq = 			new Direccion(-1,  0);
		abajo_izq = 	new Direccion(-1, -1);
		abajo = 		new Direccion( 0, -1);
		abajo_der = 	new Direccion( 1, -1);
    }
	
	private static ArrayList<Direccion> sinDiagonales = new ArrayList<Direccion>(Arrays.asList(der, arriba, izq, abajo));
	private static ArrayList<Direccion> conDiagonales = new ArrayList<Direccion>(Arrays.asList(der, arriba_der, arriba, arriba_izq, izq, abajo_izq, abajo, abajo_der));
	
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