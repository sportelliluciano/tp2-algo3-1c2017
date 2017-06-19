package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Modo;

public class MajinBooNormal extends Modo {
	public MajinBooNormal() {
    	nombre = "Majin Boo Normal";
    	velocidad = 2;
    	ataqueBasico = new AtaqueBasico(30);
        distanciaDeAtaque = 2;
       
        costoKiSiguienteTransformacion = 20;
        siguienteModo = new MajinBooMalo();
    }
}
