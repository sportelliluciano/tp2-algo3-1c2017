package integration.consignas_semana_2;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class TestSemana2Consigna07 {

	@Test
	public void test07aTransformarCellAsemiPerfectoAbsorbiendoCuatroVecesCambiaModo() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada {
        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();
		tablero.agregarPosicionable(cell, new Posicion(5,6));
		
		for(int i = 0; i < 4; i++){//necesita absorber 4 veces para la transformacion semiPerfecto
			cell.pasarTurno();
			cell.ataqueEspecialA(goku, tablero);//absorbe vida
		}
		
		cell.transformarse();
		
		assertEquals(cell.getNombre(),"Cell Semi-perfecto");
	
	
	}
	
	@Test
	public void test07bTransformarCellAPerfectoAbsorbiendoOchoVecesCambiaModo() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada {
        Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		tablero.agregarPosicionable(goku,new Posicion(5,5));
		
		Piccolo piccolo = guerreros.getPiccolo();
		tablero.agregarPosicionable(piccolo,new Posicion(6,5));
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();
		tablero.agregarPosicionable(cell, new Posicion(5,6));
		
		for(int i = 0; i < 4; i++){//necesita absorber 4 veces para la transformacion semiPerfecto
			cell.pasarTurno();
			cell.ataqueEspecialA(goku, tablero);//absorbe vida
		}
		
		cell.transformarse();
		
		for(int j = 0; j < 8; j++){//necesita absorber 8 veces para la transformacion Perfecto
			cell.pasarTurno();
			cell.ataqueEspecialA(piccolo, tablero);//absorbe vida
		}
		
		cell.transformarse();
		
		assertEquals(cell.getNombre(),"Cell Perfecto");
	
	
	}

}
