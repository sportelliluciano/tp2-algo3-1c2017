package model.personajes.modos;

import model.atributos_de_unidad.Modo;

public class FreezerNormal extends Modo {
	
	
    public FreezerNormal() {
    	nombre = "Freezer Normal";
    	velocidad = 4;
    	ataqueBasico = 20;
        distanciaDeAtaque = 2;
       
        costoKiSiguienteTransformacion = 20;
        siguienteModo = new FreezerSegundaForma();
    }
    
}