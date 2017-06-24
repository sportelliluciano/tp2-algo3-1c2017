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

public class TestSemana2Consigna06 {

	@Test
	public void test06CellAbsorbiendoVidaIncrementaVidaPropiaYdisminuyeLaDelOponenteEnIgualCantidad() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance, ErrorUnidadParalizada {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();//500 de vida
		
		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();//500 de vida

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(cell, new Posicion(5,5));	
		tablero.agregarPosicionable(goku, new Posicion(5,6));

		goku.ataqueBasicoA(cell, tablero);//la vida de cell ahora es 480
		assertEquals(cell.getVida().getPorcentajeVida(),96);//96%

		cell.pasarTurno();// para que carge el ki para poder hacer el ataque especial
		cell.ataqueEspecialA(goku, tablero);//absorbe vida a goku (-20 de vida goku +20 de vida cell)
		
		assertEquals(goku.getVida().getPorcentajeVida(),96);//96%
		assertEquals(cell.getVida().getPorcentajeVida(),100);//100%

	}
	

}
