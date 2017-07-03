package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Estado;
import model.efectos.Efecto;
import model.efectos.EfectoEsferaDelDragon;
import model.efectos.EfectoNubeVoladora;
import model.efectos.Paralizante;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;


public class TestEstado {
	
	final private int TEST_PODER_PELEA = 100;
	
	@Test (expected =  ErrorUnidadParalizada.class)
	public void testMoverseConUnidadParalizadaDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
	        
		 int duracion = 2;
		 
		 Paralizante paralizante = new Paralizante(duracion);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
		 efectos.add(paralizante);
		 
		 estado.aplicarEfectos(efectos);
         	
		 estado.getVelocidad(1);
	}
	
	@Test (expected =  ErrorKiInsuficiente.class)
	public void testReducirKiNuloDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);//al inicio el ki es nulo
		 
		 estado.reducirKi(1);//trato de reducir ki que vale 0
	}
	
	@Test 
	public void testRecibirAtaqueReduceVida() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
	        
	     Ataque ataque = new AtaqueBasico(TEST_PODER_PELEA);
	     
	     estado.recibirAtaque(ataque, TEST_PODER_PELEA);
	     
	     assertEquals(estado.getVida().getVidaActual(),vidaMaxima - 100);
	     
	}
	
        @Test
	public void testRecibirAtaqueMayorQueLaVidaDaCero() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 50;
		 
		 Estado estado = new Estado(vidaMaxima);
	        
	     Ataque ataque = new AtaqueBasico(TEST_PODER_PELEA);
	     
	     estado.recibirAtaque(ataque, TEST_PODER_PELEA);
	     
	     assertEquals(estado.getVida().getVidaActual(),0);
	     
	}
	
	@Test
	public void testAplicarVarios() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	        
		 EfectoEsferaDelDragon boostAtaque = new EfectoEsferaDelDragon();
		 efectos.add(boostAtaque);//da 25% mas de daño
		 
		 EfectoEsferaDelDragon boostEsfera = new EfectoEsferaDelDragon();
		 efectos.add(boostEsfera);//da 25% mas de daño
		 
		 EfectoNubeVoladora boostVelocidad = new EfectoNubeVoladora();
		 efectos.add(boostVelocidad);

		 estado.aplicarEfectos(efectos);
		 
		 int velocidad = 2;
		 assertEquals(velocidad*2, estado.getVelocidad(velocidad));//tiene que dar 200% mas
		 
		 int poderPelea = 100;
		 assertEquals((int)(poderPelea + poderPelea*0.5), estado.getPoderDePelea(poderPelea));//tiene que dar 50% mas

	}

	

	@Test
	public void testEstarParalizadoUnTurnoPasarElTurnoReduceElDuracionDeOtroEfecto() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 Estado estado = new Estado(vidaMaxima);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	       
		 int duracionPar = 1;
		 Paralizante paralizante = new Paralizante(duracionPar);
		 efectos.add(paralizante);
		 
		 EfectoNubeVoladora efectoNube = new EfectoNubeVoladora();
		 efectos.add(efectoNube);

		 estado.aplicarEfectos(efectos);
		 
		 estado.pasarTurno();
		 estado.pasarTurno();
		 
		 int velocidad = 2;
		 assertEquals(velocidad*2, estado.getVelocidad(velocidad));//tiene que dar 200% mas
		 
		 estado.pasarTurno();
		 
		 assertEquals(estado.getVelocidad(velocidad),velocidad);//tiene que dar como al inicio ya que se agoto el efecto
	}
}
