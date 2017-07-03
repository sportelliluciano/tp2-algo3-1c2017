package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.efectos.EfectoEsferaDelDragon;
import model.efectos.EfectoNubeVoladora;
import model.efectos.Paralizante;
import model.error.ErrorUnidadParalizada;

public class TestEfectos {

	@Test
	public void testCrearBoostAtaqueVerificaDuracion() {
 		EfectoEsferaDelDragon boostAtaque = new EfectoEsferaDelDragon();
 		
 		assertEquals(boostAtaque.tiempoRestante(),2);
	}
	
	@Test
	public void testCrearBoostAtaqueVerificaPorcentaje() throws ErrorUnidadParalizada {
		EfectoEsferaDelDragon boostAtaque = new EfectoEsferaDelDragon();
 		
 		assertEquals(25, boostAtaque.getBoostPoderDePelea(100));
	}

	@Test 
	public void testAplicarBoostParalizarVerificaDuracion() {
		int duracion = 1;
		
		Paralizante paralizante = new Paralizante(duracion);
		paralizante.pasarTurno();
		
 		assertEquals(paralizante.tiempoRestante(),0);
	}
	
	@Test (expected = ErrorUnidadParalizada.class)
	public void testAplicarBoostParalizarLanzaUnidadParalizadaAlObtenerPoderDePelea() throws ErrorUnidadParalizada {
		int duracion = 1;
		
		Paralizante paralizante = new Paralizante(duracion);
		 		
 		assertEquals(0, paralizante.getBoostPoderDePelea(100));
	}
	
	@Test 
	public void testBoostVelocidadVerificaDuracion() {
		EfectoNubeVoladora boostVelocidad = new EfectoNubeVoladora();
		boostVelocidad.pasarTurno();
		assertEquals(boostVelocidad.tiempoRestante(),2);
			
	}
	
	@Test 
	public void testBoostVelocidadVerificaPorcentaje() throws ErrorUnidadParalizada {
		EfectoNubeVoladora boostVelocidad = new EfectoNubeVoladora();
		
		assertEquals(100, boostVelocidad.getBoostVelocidad(100));
	}
	
	
}
