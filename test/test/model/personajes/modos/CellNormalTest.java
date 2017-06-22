package test.model.personajes.modos;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.ataque.AtaqueBasico;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.personajes.Cell;
import model.personajes.Goku;
import model.personajes.modos.CellSemiPerfecto;

public class CellNormalTest {

	@Test
	public void testCellRecuperaVidaAlUsarAtaqueEspecial() throws ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		GuerrerosZ guerreros = new GuerrerosZ();
		Cell cell = enemigos.getCell();
		Goku goku = guerreros.getGoku();
		Tablero tablero = new Tablero(19,23);
		tablero.agregarPosicionable(cell, new Posicion(5,5));
		tablero.agregarPosicionable(goku, new Posicion(5,6));
		
		cell.recibirAtaque(new AtaqueBasico(200));
		int vidaCellAntesAtaque = cell.getVidaActual();
		cell.pasarTurno();
		cell.ataqueEspecialA(goku, tablero);
		assertFalse(vidaCellAntesAtaque == cell.getVidaActual());
		assertEquals(goku.getVidaMaxima() - goku.getVidaActual(), cell.getVidaActual() - vidaCellAntesAtaque);
	}

	@Test
	public void testCellPuedeTransformarseDespuesDeAbsorberVida4Veces() throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		GuerrerosZ guerreros = new GuerrerosZ();
		Cell cell = enemigos.getCell();
		Goku goku = guerreros.getGoku();
		Tablero tablero = new Tablero(19,23);
		tablero.agregarPosicionable(cell, new Posicion(5,5));
		tablero.agregarPosicionable(goku, new Posicion(5,6));
		
		for (int i=0;i<4;i++) {
			cell.recibirAtaque(new AtaqueBasico(200));
			cell.pasarTurno();
			cell.ataqueEspecialA(goku, tablero);
		}
		cell.transformarse();
		assertTrue(cell.getModo() instanceof CellSemiPerfecto);
	}
	
	@Test (expected = ErrorNoCumpleReqTrans.class)
	public void testCellNoPuedeTransformarseSinAbsorberVida4Veces() throws ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		GuerrerosZ guerreros = new GuerrerosZ();
		Cell cell = enemigos.getCell();
		Goku goku = guerreros.getGoku();
		Tablero tablero = new Tablero(19,23);
		tablero.agregarPosicionable(cell, new Posicion(5,5));
		tablero.agregarPosicionable(goku, new Posicion(5,6));
		
		for (int i=0;i<3;i++) {
			cell.recibirAtaque(new AtaqueBasico(200));
			cell.pasarTurno();
			cell.ataqueEspecialA(goku, tablero);
		}
		cell.transformarse();
		fail("Debería haber lanzado ErrorNoCumpleReqTrans");
	}
}
