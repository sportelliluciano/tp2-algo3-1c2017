package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.ConvierteteEnChocolate;
import model.atributos_de_unidad.Modo;

public class MajinBooMalo extends Modo {
	public MajinBooMalo() {
    	nombre = "Boo Malo";
    	velocidad = 3;
    	distanciaDeAtaque = 2;
    	ataqueBasico = new AtaqueBasico(50);
        ataqueEspecial = new ConvierteteEnChocolate();
        poderDeAtaque = 50;
        
        costoKiSiguienteTransformacion = 50;
        siguienteModo = new MajinBooOriginal();
    }
}
