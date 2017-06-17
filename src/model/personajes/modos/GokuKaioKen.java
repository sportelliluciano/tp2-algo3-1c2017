package model.personajes.modos;

import model.ataque.AtaqueBasico;
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
	
}