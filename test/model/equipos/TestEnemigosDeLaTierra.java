package model.equipos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Equipo;
import model.Unidad;
import model.ataque.AtaqueBasico;
import model.consumibles.EsferaDelDragon;
import model.personajes.Cell;
import model.personajes.Freezer;
import model.personajes.MajinBoo;

public class TestEnemigosDeLaTierra {

	@Test
	public void testGetCellDevuelveInstanciaDeCell() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		assertTrue(enemigos.getCell() instanceof Cell);
	}
	
	@Test
	public void testGetFreezerDevuelveInstanciaDeFreezer() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		assertTrue(enemigos.getFreezer() instanceof Freezer);
	}
	
	@Test
	public void testGetMajinBooDevuelveInstanciaDeMajinBoo() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		assertTrue(enemigos.getMajinBoo() instanceof MajinBoo);
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonEs0AlCrear() {
		Equipo enemigos = new EnemigosDeLaTierra();
		assertEquals(0, enemigos.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlCellConsumirEsfera() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad personaje = enemigos.getCell();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, enemigos.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlMajinBooConsumirEsfera() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad personaje = enemigos.getMajinBoo();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, enemigos.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlFreezerConsumirEsfera() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad personaje = enemigos.getFreezer();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, enemigos.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testObtenerIntegrantesDelEquipoPerteneceDevuelveTrueACadaUno() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad cell = enemigos.getCell(),
			   freezer = enemigos.getFreezer(), 
			   majinboo = enemigos.getMajinBoo();
		assertTrue(enemigos.pertenece(cell));
		assertTrue(enemigos.pertenece(freezer));
		assertTrue(enemigos.pertenece(majinboo));
	}
	
	@Test
	public void testCrearDosGuerrerosZIntegrantesDeUnEquipoNoPertenecenAlOtro() {
		EnemigosDeLaTierra enemigos1 = new EnemigosDeLaTierra(), enemigos2 = new EnemigosDeLaTierra();
		Unidad cell1 = enemigos1.getCell(),
			   freezer1 = enemigos1.getFreezer(), 
			   majinboo1 = enemigos1.getMajinBoo();
		Unidad cell2 = enemigos2.getCell(),
			   freezer2 = enemigos2.getFreezer(), 
			   majinboo2 = enemigos2.getMajinBoo();
		assertFalse(enemigos1.pertenece(cell2));
		assertFalse(enemigos1.pertenece(freezer2));
		assertFalse(enemigos1.pertenece(majinboo2));
		
		assertFalse(enemigos2.pertenece(cell1));
		assertFalse(enemigos2.pertenece(freezer1));
		assertFalse(enemigos2.pertenece(majinboo1));
	}

	@Test
	public void testObtenerIntegrantesDevuelveUnaListaUnicamenteConLosIntegrantes() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad cell = enemigos.getCell(),
			   freezer = enemigos.getFreezer(), 
			   majinboo = enemigos.getMajinBoo();
		List<Unidad> integrantes = enemigos.integrantes();
		assertTrue(integrantes.contains(cell));
		assertTrue(integrantes.contains(freezer));
		assertTrue(integrantes.contains(majinboo));
		assertEquals(3, integrantes.size());
	}
	
	
	@Test
	public void testPasarTurnoHacePasarElTurnoATodosLosIntegrantes() {
		EnemigosDeLaTierra enemigos = new EnemigosDeLaTierra();
		Unidad cell = enemigos.getCell(),
			   freezer = enemigos.getFreezer(), 
			   majinboo = enemigos.getMajinBoo();
		int kiAntesCell = cell.getKi().getMagnitud();
		int kiAntesFreezer = freezer.getKi().getMagnitud();
		int kiAntesMajinBoo = majinboo.getKi().getMagnitud();
		enemigos.pasarTurno();
		assertEquals(5 + kiAntesCell, cell.getKi().getMagnitud());
		assertEquals(5 + kiAntesFreezer, freezer.getKi().getMagnitud());
		assertEquals(5 + kiAntesMajinBoo, majinboo.getKi().getMagnitud());
	}
	
	@Test
	public void testEquipoEstaVivoAlCrear() {
		Equipo enemigos = new EnemigosDeLaTierra();
		assertTrue(enemigos.estaVivo());
	}
	
	@Test
	public void testEquipoNoEstaVivoAlMatarATodosSusPersonajes() {
		Equipo enemigos = new EnemigosDeLaTierra();
		for (Unidad integrante : enemigos.integrantes()) {
			integrante.recibirAtaque(new AtaqueBasico(integrante.getVida().getVidaMaxima() * 2));
		}
		assertFalse(enemigos.estaVivo());
	}
	
	@Test
	public void testNombreDelEquipoEsGuerrerosZ() {
		Equipo enemigos = new EnemigosDeLaTierra();
		assertEquals("Enemigos de la Tierra", enemigos.getNombre());
	}
}
