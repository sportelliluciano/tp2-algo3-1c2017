package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.ataque.Ataque;
import model.ataque.AtaqueBasico;
import model.atributos_de_unidad.Estado;
import model.efectos.BoostAtaque;
import model.efectos.BoostEsfera;
import model.efectos.BoostVelocidad;
import model.efectos.Efecto;
import model.efectos.Paralizante;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;


public class TestEstado {
	
	@Test (expected =  ErrorUnidadParalizada.class)
	public void testMoverseConUnidadParalizadaDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
	        
		 int duracion = 2;
		 
		 Paralizante paralizante = new Paralizante(duracion);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
		 efectos.add(paralizante);
		 
		 estado.aplicarEfectos(efectos);
         	
		 estado.moverseEsPosible();
	     
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
	        
	     Ataque ataque = new AtaqueBasico(100);
	     
	     estado.recibirAtaque(ataque);
	     
	     assertEquals(estado.getVida().getVidaActual(),vidaMaxima - 100);
	     
	}
	
        @Test
	public void testRecibirAtaqueMayorQueLaVidaDaCero() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 50;
		 
		 Estado estado = new Estado(vidaMaxima);
	        
	     Ataque ataque = new AtaqueBasico(100);
	     
	     estado.recibirAtaque(ataque);
	     
	     assertEquals(estado.getVida().getVidaActual(),0);
	     
	}
	
	@Test
	public void testAplicarVarios() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	        
		 int duracion = 2;
		 int porcPoder = 175;
		 
		 BoostAtaque boostAtaque = new BoostAtaque(porcPoder,duracion);
		 efectos.add(boostAtaque);//da 175% mas de daño
		 
		 BoostEsfera boostEsfera = new BoostEsfera();
		 efectos.add(boostEsfera);//da 25% mas de daño
		 
		 int porcVel = 200;
		 BoostVelocidad boostVelocidad = new BoostVelocidad(duracion,porcVel);
		 efectos.add(boostVelocidad);

		 estado.aplicarEfectos(efectos);
		 
		 int velocidad = 2;
		 assertEquals(estado.getVelocidad(velocidad),velocidad + velocidad*2);//tiene que dar 200% mas
		 
		 int poderPelea = 100;
		 assertEquals(estado.getPoderDePelea(poderPelea),poderPelea + poderPelea*2);//tiene que dar 200% mas

	}

	

	@Test
	public void testEstarParalizadoUnTurnoPasarElTurnoReduceElDuracionDeOtroEfecto() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 Estado estado = new Estado(vidaMaxima);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	       
		 int duracionPar = 1;
		 Paralizante paralizante = new Paralizante(duracionPar);
		 efectos.add(paralizante);
		 
		 int duracionVel = 2;		 
		 int porcVel = 200;
		 BoostVelocidad boostVelocidad = new BoostVelocidad(duracionVel,porcVel);
		 efectos.add(boostVelocidad);

		 estado.aplicarEfectos(efectos);
		 
		 estado.pasarTurno();
		 
		 int velocidad = 2;
		 assertEquals(estado.getVelocidad(velocidad),velocidad + velocidad*2);//tiene que dar 200% mas
		 
		 estado.pasarTurno();
		 
		 assertEquals(estado.getVelocidad(velocidad),velocidad);//tiene que dar como al inicio ya que se agoto el efecto
	}
	/*
    //no se si es necesario,pero lo dejo comentado
	@Test
	public void testEstarParalizadoCeroTurnosNoInmobiliza() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		
		 int vidaMaxima = 500;
		 
		 Estado estado = new Estado(vidaMaxima);
		 
		 ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	       
		 int duracionPar = 0;
		 Paralizante paralizante = new Paralizante(duracionPar);
	     efectos.add(paralizante);
		 
		 estado.aplicarEfectos(efectos);
		 
		 assertTrue(!estado.paralizado());
		 
	}*/
    /*
	//no se si es necesario checkear esto lo dejo comentado,en tal caso se debe crear la clase de error
	@Test (expected = ErrorDuracionInvalidad.class ) 
	public void testEstarParalizadoNegativoTurnosDaError() throws ErrorDuracionInvalidad, ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorKiInsuficiente, ErrorEnemigoFueraDeAlcance {		 
		 int duracionPar = -4;
		 Paralizante paralizante = new Paralizante(duracionPar);
		 
	}
	*/
}
