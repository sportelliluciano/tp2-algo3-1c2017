package model.personajes.modos;

import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Modo;
import model.equipos.GuerrerosZ;

public class GohanNormal extends Modo {

    public GohanNormal(GuerrerosZ equipo) {
    	nombre = "Gohan Normal";
    	velocidad = 2;
    	distanciaDeAtaque = 2;
     	ataqueBasico = new AtaqueBasico(15);
     	
     	costoKiSiguienteTransformacion = 10;
        siguienteModo = new GohanSSJFase1(equipo);
    }
    
}
