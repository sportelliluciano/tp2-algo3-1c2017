package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;

public class PiccoloNormal extends Modo {

	public PiccoloNormal(GuerrerosZ equipo) {
		nombre = "Piccolo Normal";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = new AtaqueBasico(20);
     	
     	costoKiSiguienteTransformacion = 20;
        siguienteModo = new PiccoloFortalecido(equipo);
	}
	
}
