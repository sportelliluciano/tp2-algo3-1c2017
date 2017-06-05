package integration;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestFirstWeek {
	
	@Test
	public void test01MoveCharacterAndCheckNewPosition(){
		// TODO: Implement
		
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku
		// Preguntar o setear su posicion (x,y) a un lugar con nada alrededor
		// Moverlo a (x+1,y)
		// assertTrue(x_new == x+1 && y_new == y+1);
		
		assertTrue(false);
	}
	
	@Test
	public void test02aCantSpawnCharacterInAnotherCharactersCell() {
		// TODO: Implement
		
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku.
		// Crear un gohan, seteando su posicion (x,y) a la misma de goku
		// O bien hacemos que explote y capturamos la excepcion..
		// o bien, que no cree al gohan y confirmar (por tablero o juego) que solo goku existe.
		
		assertTrue(false);
	}
	
	@Test
	public void test02bCantMoveCharacterToFriendlyCharactersCell() {
		// TODO: Implement
	
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku
		// Crear un gohan del mismo bando, ubicado bien cerquita de goku
		// Tratar de mover a gohan a la posicion de goku.
		// O bien tirar excepcion ahi y esperarla con el test, o tener una funcion de "puede moverse ahi" q de false.

		assertTrue(false);
	}
	
	@Test
	public void test02cCantMoveCharacterToEnemyCharactersCell() {
		// TODO: Implement
	
		// Lo mismo que la anterior pero con un Freezer del oponente en vez de Gohan.

		assertTrue(false);
	}
	
	@Test
	public void test03aCharacterCantMoveThroughFriendlyCharactersCell() {
		// TODO: Implement
	
		// Crear tablero (si es posible sin consumibles)
		// Crear un goku
		// Crear un gohan del mismo bando, ubicado bien cerquita de goku
		// Tratar de mover a gohan 2 lugares abajo y 2 a la izquierda (lo que haria q tuviera que pasar encima de goku)
		// O bien tirar excepcion ahi y esperarla con el test, o tener una funcion de "puede moverse ahi" q de false.

		assertTrue(false);
	}
	
	@Test
	public void test03bCharacterCantMoveThroughEnemyCharactersCell() {
		// TODO: Implement
	
		// Lo mismo que la anterior pero con un Freezer del oponente en vez de Gohan

		assertTrue(false);
	}
	
	@Test
	public void test04CheckIfCharacterTransformed() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test05MoveCharacterAfterTransform() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test06CreateAGameCheckCharacterPositions() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test07AttackingEnemyTooFarAwayDoesntDamageIt() {
		// TODO: Implement
		assertTrue(false);
	}
	
	@Test
	public void test07AttackingEnemyCloseEnoughDamagesIt() {
		// TODO: Implement
		assertTrue(false);
	}
	
}
