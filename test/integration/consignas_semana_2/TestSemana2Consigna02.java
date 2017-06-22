package integration.consignas_semana_2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.Unidad;
import model.ataque.AtaqueBasico;
import model.equipos.GuerrerosZ;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;

public class TestSemana2Consigna02 {

	@Test
	public void test02TransformarGohanAultilmaTransformacionConAliadosDeVidaInferiorAlTreintaPorcientoCambiaElModo() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		Tablero tablero = new Tablero(20,20);
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Unidad gohan = guerreros.getGohan(),goku = guerreros.getGoku(), piccolo = guerreros.getPiccolo();	
		
		tablero.agregarPosicionable(gohan, new Posicion(3,3));
		tablero.agregarPosicionable(goku, new Posicion(3,4));
		tablero.agregarPosicionable(piccolo, new Posicion(4,3));

		for (int i = 0; i < 2; i++) // Gohan requiere 10 ki para SSJ1 y 
			gohan.pasarTurno();		// carga 5 ki por turno.
		
		gohan.transformarse();
		
		for (int i = 0; i < 6; i++) // Gohan requiere 30 ki para SSJ2 y 
			gohan.pasarTurno();		// carga 5 ki por turno.
		
		AtaqueBasico ataque = new AtaqueBasico(400);
		
		goku.recibirAtaque(ataque);//tiene 500 de vida entonces lo dejo con 100 puntos(20%)
		piccolo.recibirAtaque(ataque);//tiene 500 de vida entonces lo dejo con 100 puntos(20%)
		
		gohan.transformarse();
		
		assertTrue(gohan.getModo().getNombre().equals("Gohan Super Sayajin Fase 2"));
		
	}

}
