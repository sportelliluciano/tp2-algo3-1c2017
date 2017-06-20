package integration.consignas_semana_2;

import org.junit.Test;

import model.Posicion;
import model.Tablero;
import model.equipos.EnemigosDeLaTierra;
import model.error.ErrorNoCumpleReqTrans;
import model.error.ErrorNoHayMasTrans;
import model.error.ErrorPosicionInvalida;
import model.personajes.Cell;

public class TestSemana2Consigna05 {
    
	@Test(expected = ErrorNoCumpleReqTrans.class)
	public void test05TransformarCellSinAbsorberCuatroVecesDaError() throws ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarUnidad(cell, new Posicion(5,5));	

		cell.transformarse();
	}
	

}
