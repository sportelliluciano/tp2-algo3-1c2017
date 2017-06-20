package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.Kamehameha;
import model.atributos_de_unidad.Modo;

public class GokuNormal extends Modo {
	
    public GokuNormal() {
    	nombre            = "Goku Normal";
    	velocidad         = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico      = new AtaqueBasico(20);
     	poderDeAtaque = 20;
     	
     	costoKiSiguienteTransformacion = 20;
        siguienteModo     = new GokuKaioKen();
    }

    @Override
    public void incrementarPoderPelea(double multiplicador) {
    	ataqueBasico = new AtaqueBasico((int)(20 * multiplicador));
    	ataqueEspecial = new Kamehameha((int)(20 * multiplicador));
    }
}
