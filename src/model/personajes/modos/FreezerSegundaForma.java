package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Modo;

public class FreezerSegundaForma extends Modo {
	public FreezerSegundaForma() {
    	nombre = "Freezer Segunda Forma";
    	velocidad = 4;
    	distanciaDeAtaque = 3;
    	ataqueBasico = new AtaqueBasico(40);
       
        costoKiSiguienteTransformacion = 50;
        siguienteModo = new FreezerDefinitivo();
    }
}
