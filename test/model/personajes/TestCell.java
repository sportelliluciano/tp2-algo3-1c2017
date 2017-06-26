package model.personajes;

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

public class TestCell {

	@Test
	public void testTransformarCellAsemiPerfectoConAbsorsicionesSuficientes() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		
		Tablero tablero = new Tablero(19,23);
		
	    tablero.agregarPosicionable(goku, new Posicion(5,6));	
		tablero.agregarPosicionable(cell, new Posicion(5,5));	

		for(int i = 0; i < 4; i++){//debe absorber 4
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse(); 
		
		assertEquals(cell.getNombre(),"Cell Semi-perfecto");

	}

	
	@Test (expected = ErrorNoCumpleReqTrans.class ) 
	public void testTransformarCellAsemiPerfectoConAbsorcionesInsuficientesDaError() throws ErrorKiInsuficiente, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorPosicionInvalida {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		Tablero tablero = new Tablero(19,23);
		
		tablero.agregarPosicionable(cell, new Posicion(5,5));	
		
		cell.transformarse(); 
		
	}
	
	@Test
	public void testTransformarCellAPerfectoConAbsorcionesSuficientes() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		
		Tablero tablero = new Tablero(19,23);
		
	    tablero.agregarPosicionable(goku, new Posicion(5,6));	
		tablero.agregarPosicionable(cell, new Posicion(5,5));	

		for(int i = 0; i < 4; i++){//debe absorber 4
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse(); 
		
		for(int i = 0; i < 8; i++){//debe absorber 8
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse();
		
		assertEquals(cell.getNombre(),"Cell Perfecto");

	}
	
	@Test (expected = ErrorNoCumpleReqTrans.class)
	public void testTransformarCellAperfectoConAbsorcionesInsuficientesDaError() throws ErrorNoCumpleReqTrans, ErrorPosicionInvalida, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance{	
	    EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
	    Cell cell = enemigos.getCell();

	    GuerrerosZ guerreros = new GuerrerosZ();
	    Goku goku = guerreros.getGoku();
	
	    Tablero tablero = new Tablero(19,23);
	
	    tablero.agregarPosicionable(goku, new Posicion(5,6));	
	    tablero.agregarPosicionable(cell, new Posicion(5,5));	

	    for(int i = 0; i < 4; i++){//debe absorber 4
		    cell.pasarTurno();//carga ki
		    cell.ataqueEspecialA(goku, tablero);//absorbe
	    }
	
	    cell.transformarse(); 
	
    	//omito las 8 absorciones
	
	    cell.transformarse();
}
	
	@Test
	public void testTirarAtaqueEspecialAbsorberConAbsorcionesSuficientesVerificaIncrementoVidaEnCellYdecrementoVidaEnAbversario() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerrerosZ = new GuerrerosZ();
		Goku goku = guerrerosZ.getGoku();
		tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell= enemigos.getCell();
		tablero.agregarPosicionable(cell, new Posicion(5,5));	
		
		for(int i = 0; i <= 4; i++)
			goku.ataqueBasicoA(cell, tablero);

		int vidaCellPostAtaqueGoku = cell.getVida().getVidaActual();
		
		//cell queda con 400 de vida
		
		for(int i = 0; i <= 4; i++){
			cell.pasarTurno();
			cell.ataqueEspecialA(goku, tablero);//absorbe 20 de vida
		}	
		
		int vidaAbsorbida = 20*5;//poderAtaqueGoku*turnos
		
        assertEquals(cell.getVida().getVidaActual(),vidaCellPostAtaqueGoku + vidaAbsorbida);		
		assertEquals(goku.getVida().getVidaActual(),goku.getVida().getVidaMaxima() - vidaAbsorbida);

	}
	

	@Test(expected = ErrorKiInsuficiente.class)
	public void testTirarAtaqueEspecialConAbsorcionesInsuficientesDaError() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		Tablero tablero = new Tablero(19,23);
		
		GuerrerosZ guerrerosZ = new GuerrerosZ();
		Goku goku = guerrerosZ.getGoku();
		tablero.agregarPosicionable(goku, new Posicion(5,4));	
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();
		tablero.agregarPosicionable(cell, new Posicion(5,5));	
		
		cell.ataqueEspecialA(goku, tablero);

	}
	
	
	@Test
	public void testTransformarCellAPerfectoConAbsorcionesSuficientesYAbsorberVerificaDañoYvidaAbsorbidaSuperior() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		Piccolo piccolo = guerreros.getPiccolo();
		
		Tablero tablero = new Tablero(19,23);
		
	    tablero.agregarPosicionable(goku, new Posicion(5,6));	
		tablero.agregarPosicionable(cell, new Posicion(5,5));	
		tablero.agregarPosicionable(piccolo, new Posicion(5,4));	


		for(int i = 0; i < 4; i++){//debe absorber 4
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse(); 
		
		for(int i = 0; i < 8; i++){//debe absorber 8
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse();//ya esta transformado a la ultima transformacion
		
		int vidaCellAntesAtaquePiccolo = cell.getVida().getVidaActual();
		
		for(int i = 0; i < 4 ; i++)//le saco 80 de vida a cell
			piccolo.ataqueBasicoA(cell, tablero);
		
		cell.pasarTurno();//cargo ki
		
		int vidaPiccoloAntesAtaqueCell = piccolo.getVida().getVidaActual();
		
		cell.ataqueEspecialA(piccolo, tablero);//absorbe 80 de vida
		
		int vidaPiccoloPostAtaqueCell = piccolo.getVida().getVidaActual();
		
		assertEquals(vidaPiccoloAntesAtaqueCell - vidaPiccoloPostAtaqueCell,80);
		assertEquals(cell.getVida().getVidaActual(),vidaCellAntesAtaquePiccolo);
		
	}

	@Test (expected = ErrorNoHayMasTrans.class)
	public void testTratarDeTransformarCellDespuesDeUltimaTransformacionDaError() throws ErrorPosicionInvalida, ErrorNoCumpleReqTrans, ErrorNoHayMasTrans, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Cell cell = enemigos.getCell();

		GuerrerosZ guerreros = new GuerrerosZ();
		Goku goku = guerreros.getGoku();
		
		Tablero tablero = new Tablero(19,23);
		
	    tablero.agregarPosicionable(goku, new Posicion(5,6));	
		tablero.agregarPosicionable(cell, new Posicion(5,5));	

		for(int i = 0; i < 4; i++){//debe absorber 4
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse(); 
		
		for(int i = 0; i < 8; i++){//debe absorber 8
			cell.pasarTurno();//carga ki
			cell.ataqueEspecialA(goku, tablero);//absorbe
		}
		
		cell.transformarse();//llego a la ultima transformacion
		
		cell.transformarse();//No hay mas
		
	}
	
}
