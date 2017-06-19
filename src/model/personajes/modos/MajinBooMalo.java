package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Modo;

public class MajinBooMalo extends Modo {
	public MajinBooMalo() {
    	nombre = "Boo Malo";
    	velocidad = 3;
    	ataqueBasico = new AtaqueBasico(50);
        distanciaDeAtaque = 2;
       
        costoKiSiguienteTransformacion = 50;
        siguienteModo = new MajinBooOriginal();
    }
}
