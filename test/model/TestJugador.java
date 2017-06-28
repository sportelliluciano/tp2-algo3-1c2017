package model;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Juego;
import model.Jugador;
import model.Posicion;
import model.equipos.EnemigosDeLaTierra;
import model.equipos.GuerrerosZ;
import model.error.ErrorEnemigoFueraDeAlcance;
import model.error.ErrorKiInsuficiente;
import model.error.ErrorPosicionInvalida;
import model.error.ErrorUnidadNoEsEnemiga;
import model.error.ErrorUnidadParalizada;
import model.personajes.Freezer;
import model.personajes.Goku;

public class TestJugador {

	@Test (expected = RuntimeException.class)
	public void testMoverUnidadAjenaDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
	        Juego juego = new Juego(jugador1,jugador2);
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);
				
		jugador1.mover(enemigos.getFreezer() , new Posicion(1,1));
	}

	@Test 
	public void testMoverUnidadCambiaPos() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		 
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();
								
		jugador1.mover(goku ,posGokuIni.add(new Posicion(1,0)));
		
		Posicion posGokuFin = goku.getPosicion();
		
		assertTrue(posGokuIni != posGokuFin);
		
	}
	
	
	@Test (expected = RuntimeException.class)
	public void testMoverDosVecesDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();
								
		jugador1.mover(goku ,posGokuIni.add(new Posicion(1,0)));
		
		Posicion posGokuFin = goku.getPosicion();
		
		jugador1.mover(goku ,posGokuFin.add(new Posicion(1,0)));
		
	}
	

	@Test (expected = RuntimeException.class)
	public void testAtacarUnidadAliadaDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
	        Juego juego = new Juego(jugador1,jugador2);
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);
				
		jugador1.ataqueBasico(guerreros.getGoku(), guerreros.getGohan());
	}

	
	@Test (expected = RuntimeException.class)
	public void testAtacarDosVecesDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
                Freezer freezer = enemigos.getFreezer();
        
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();/*(0,2)*/ 
		Posicion posFreezerIni = freezer.getPosicion();/*(14,7)*/ 
		
		Posicion posDer = new Posicion(1,0);
		Posicion posArriba = new Posicion(0,1);
		Posicion posIzq = new Posicion(-1,0);
		Posicion posAbajo = new Posicion(0,-1);
		
		//trato de acercar los personajes para que se pueda atacar
		for(int i = 1; i <= 7; i++){
			jugador1.mover(goku, posGokuIni.add(posDer));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	    	        jugador2.mover(freezer, posFreezerIni.add(posIzq));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
		
		for(int i = 1; i <= 2; i++){
			jugador1.mover(goku, posGokuIni.add(posArriba));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	        	jugador2.mover(freezer, posFreezerIni.add(posAbajo));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
			
		jugador1.ataqueBasico(goku, freezer);
		
		jugador1.ataqueBasico(goku, freezer);
				
	}
	
	
	@Test (expected = RuntimeException.class)
	public void testAtacarEspecialUnidadAliadaDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
		
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
	        Juego juego = new Juego(jugador1,jugador2);
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);
				
		jugador1.ataqueEspecial(guerreros.getGoku(), guerreros.getGohan());
	}
	

	@Test (expected = RuntimeException.class)
	public void testAtacarEspecialDosVecesDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
                Freezer freezer = enemigos.getFreezer();
        
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();/*(0,2)*/ 
		Posicion posFreezerIni = freezer.getPosicion();/*(14,7)*/ 
		
		Posicion posDer = new Posicion(1,0);
		Posicion posArriba = new Posicion(0,1);
		Posicion posIzq = new Posicion(-1,0);
		Posicion posAbajo = new Posicion(0,-1);
		
		//trato de acercar los personajes para que se pueda atacar
		for(int i = 1; i <= 7; i++){
			jugador1.mover(goku, posGokuIni.add(posDer));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	         	jugador2.mover(freezer, posFreezerIni.add(posIzq));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
		
		for(int i = 1; i <= 2; i++){
			jugador1.mover(goku, posGokuIni.add(posArriba));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	    	        jugador2.mover(freezer, posFreezerIni.add(posAbajo));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
			
		jugador1.ataqueEspecial(goku, freezer);
		
		jugador1.ataqueEspecial(goku, freezer);
				
	}
	

	@Test (expected = RuntimeException.class)
	public void testAtacarMixDosVecesDaError() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
                Freezer freezer = enemigos.getFreezer();
        
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();/*(0,2)*/ 
		Posicion posFreezerIni = freezer.getPosicion();/*(14,7)*/ 
		
		Posicion posDer = new Posicion(1,0);
		Posicion posArriba = new Posicion(0,1);
		Posicion posIzq = new Posicion(-1,0);
		Posicion posAbajo = new Posicion(0,-1);
		
		//trato de acercar los personajes para que se pueda atacar
		for(int i = 1; i <= 7; i++){
			jugador1.mover(goku, posGokuIni.add(posDer));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	    	        jugador2.mover(freezer, posFreezerIni.add(posIzq));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
		
		for(int i = 1; i <= 2; i++){
			jugador1.mover(goku, posGokuIni.add(posArriba));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	    	        jugador2.mover(freezer, posFreezerIni.add(posAbajo));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
			
		jugador1.ataqueBasico(goku, freezer);
		
		jugador1.ataqueEspecial(goku, freezer);
				
	}


	@Test 
	public void testAtacarDisminuyeVidaRival() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
                Freezer freezer = enemigos.getFreezer();
        
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();/*(0,2)*/ 
		Posicion posFreezerIni = freezer.getPosicion();/*(14,7)*/ 
		
		Posicion posDer = new Posicion(1,0);
		Posicion posArriba = new Posicion(0,1);
		Posicion posIzq = new Posicion(-1,0);
		Posicion posAbajo = new Posicion(0,-1);
		
		//trato de acercar los personajes para que se pueda atacar
		for(int i = 1; i <= 7; i++){
			jugador1.mover(goku, posGokuIni.add(posDer));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	          	jugador2.mover(freezer, posFreezerIni.add(posIzq));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
		
		for(int i = 1; i <= 2; i++){
			jugador1.mover(goku, posGokuIni.add(posArriba));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	        	jugador2.mover(freezer, posFreezerIni.add(posAbajo));
	        	posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
			
		int vidaFreezerAntesAtaque = freezer.getVida().getVidaActual();
		
		jugador1.ataqueBasico(goku, freezer);
		
		int vidaFreezerPostAtaque = freezer.getVida().getVidaActual();

		int poderPeleaGoku = 20;
		
		assertEquals(vidaFreezerAntesAtaque,vidaFreezerPostAtaque + poderPeleaGoku);
				
	}
	
	
	@Test 
	public void testAtacarEspecialDisminuyeVidaRival() throws ErrorPosicionInvalida, ErrorUnidadParalizada, ErrorUnidadNoEsEnemiga, ErrorEnemigoFueraDeAlcance, ErrorKiInsuficiente {
		
		GuerrerosZ guerreros = new GuerrerosZ();
		
		Goku goku = guerreros.getGoku();
		
		Jugador jugador1 = new Jugador("Lucy",guerreros);
 
                EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		
                Freezer freezer = enemigos.getFreezer();
        
		Jugador jugador2 = new Jugador("Jimmy",enemigos);
		
		Juego juego = new Juego(jugador1,jugador2);
		
		jugador1.setJuego(juego);
		jugador2.setJuego(juego);

		Posicion posGokuIni = goku.getPosicion();/*(0,2)*/ 
		Posicion posFreezerIni = freezer.getPosicion();/*(14,7)*/ 
		
		Posicion posDer = new Posicion(1,0);
		Posicion posArriba = new Posicion(0,1);
		Posicion posIzq = new Posicion(-1,0);
		Posicion posAbajo = new Posicion(0,-1);
		
		//trato de acercar los personajes para que se pueda atacar
		for(int i = 1; i <= 7; i++){
			jugador1.mover(goku, posGokuIni.add(posDer));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	        	jugador2.mover(freezer, posFreezerIni.add(posIzq));
	        	posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
		
		for(int i = 1; i <= 2; i++){
			jugador1.mover(goku, posGokuIni.add(posArriba));
			posGokuIni = goku.getPosicion();
			jugador1.pasarTurno();
	    	        jugador2.mover(freezer, posFreezerIni.add(posAbajo));
	    	        posFreezerIni = freezer.getPosicion();
			jugador2.pasarTurno();
		}
			
		int vidaFreezerAntesAtaque = freezer.getVida().getVidaActual();
		
		jugador1.ataqueEspecial(goku, freezer);
		
		int vidaFreezerPostAtaque = freezer.getVida().getVidaActual();

		int poderPeleaGoku = 30;
		
		assertEquals(vidaFreezerAntesAtaque,vidaFreezerPostAtaque + poderPeleaGoku);
				
	}
	
}
