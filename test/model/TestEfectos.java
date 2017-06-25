import static org.junit.Assert.*;

import org.junit.Test;

import model.efectos.BoostAtaque;
import model.efectos.BoostEsfera;
import model.efectos.BoostVelocidad;
import model.efectos.Paralizante;

public class TestEfectos {

	@Test
	public void testCrearBoostAtaqueVerificaDuracion() {
		int duracion = 1;
		int porcentaje = 200;
 		BoostAtaque boostAtaque = new BoostAtaque(porcentaje,duracion);
 		
 		assertEquals(boostAtaque.tiempoRestante(),1);
	}
	
	@Test
	public void testCrearBoostAtaqueVerificaPorcentaje() {
		int duracion = 1;
		int porcentaje = 200;
 		BoostAtaque boostAtaque = new BoostAtaque(porcentaje,duracion);
 		
 		assertEquals(boostAtaque.getBoostAtaque(),200);
	}

	@Test 
	public void testAplicarBoostParalizarVerificaDuracion() {
		int duracion = 1;
		
		Paralizante paralizante = new Paralizante(duracion);
		 		
 		assertEquals(paralizante.tiempoRestante(),1);
	}
	
	@Test 
	public void testAplicarBoostParalizarVerificaPorcentajeNulo() {
		int duracion = 1;
		
		Paralizante paralizante = new Paralizante(duracion);
		 		
 		assertEquals(paralizante.getBoostAtaque(),0);
	}
	
	@Test 
	public void testAplicarBoostEsferaVerificaDuracionDos() {
		
		BoostEsfera boostEsfera = new BoostEsfera();
		
		assertEquals(boostEsfera.tiempoRestante(),2);
		 		
	}
	
	@Test 
	public void testAplicarBoostEsferaVerificaPorcentajeVeintiCinco() {
		
		BoostEsfera boostEsfera = new BoostEsfera();
		
		assertEquals(boostEsfera.getBoostAtaque(),25);
		 		
	}
	
	@Test 
	public void testBoostVelocidadVerificaDuracion() {
		
		BoostVelocidad boostVelocidad = new BoostVelocidad(10,23);
		
		assertEquals(boostVelocidad.tiempoRestante(),10);
			
	}
	
	@Test 
	public void testBoostVelocidadVerificaPorcentaje() {
		
		BoostVelocidad boostVelocidad = new BoostVelocidad(10,23);
		
		assertEquals(boostVelocidad.getBoostVelocidad(),23);
			
	}
	
	
}
