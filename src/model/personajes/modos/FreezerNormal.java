package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.RayoMortal;
import model.atributos_de_unidad.Modo;

public class FreezerNormal extends Modo {
	
    public FreezerNormal() {
    	nombre = "Freezer Normal";
    	velocidad = 4;
    	distanciaDeAtaque = 2;
    	ataqueBasico = new AtaqueBasico(20);
        ataqueEspecial = new RayoMortal(20);
       
        costoKiSiguienteTransformacion = 20;
        siguienteModo = new FreezerSegundaForma();
    }
    
}