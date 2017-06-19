package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.ataque.Kamehameha;
import model.atributos_de_unidad.Modo;

public class GokuKaioKen extends Modo {

	public GokuKaioKen() {
		nombre            = "Kaio-ken";	
		velocidad         = 3;
		distanciaDeAtaque = 4;
		ataqueBasico      = new AtaqueBasico(40);
		
		costoKiSiguienteTransformacion = 50;
		siguienteModo     = new GokuSSJ();
	}
	
	@Override
    public void incrementarPoderPelea(double multiplicador) {
    	ataqueBasico = new AtaqueBasico((int)(40 * multiplicador));
    	ataqueEspecial = new Kamehameha((int)(40 * multiplicador));
    }
	
}