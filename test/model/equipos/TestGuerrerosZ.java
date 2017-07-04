package model.equipos;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Equipo;
import model.Unidad;
import model.ataque.AtaqueBasico;
import model.consumibles.EsferaDelDragon;
import model.personajes.Gohan;
import model.personajes.Goku;
import model.personajes.Piccolo;

public class TestGuerrerosZ {

	@Test
	public void testGetGokuDevuelveInstanciaDeGoku() {
		GuerrerosZ guerreros = new GuerrerosZ();
		assertTrue(guerreros.getGoku() instanceof Goku);
	}
	
	@Test
	public void testGetGokuDevuelveInstanciaDeGohan() {
		GuerrerosZ guerreros = new GuerrerosZ();
		assertTrue(guerreros.getGohan() instanceof Gohan);
	}
	
	@Test
	public void testGetGokuDevuelveInstanciaDePiccolo() {
		GuerrerosZ guerreros = new GuerrerosZ();
		assertTrue(guerreros.getPiccolo() instanceof Piccolo);
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonEs0AlCrear() {
		Equipo guerreros = new GuerrerosZ();
		assertEquals(0, guerreros.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlGokuConsumirEsfera() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad personaje = guerreros.getGoku();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, guerreros.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlGohanConsumirEsfera() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad personaje = guerreros.getGohan();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, guerreros.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testCantidadDeEsferasDelDragonAumentanAlPiccoloConsumirEsfera() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad personaje = guerreros.getPiccolo();
		personaje.consumir(new EsferaDelDragon());
		assertEquals(1, guerreros.cantidadDeEsferasDelDragon());
	}
	
	@Test
	public void testObtenerIntegrantesDelEquipoPerteneceDevuelveTrueACadaUno() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad goku = guerreros.getGoku(),
			   gohan = guerreros.getGohan(), 
			   piccolo = guerreros.getPiccolo();
		assertTrue(guerreros.pertenece(goku));
		assertTrue(guerreros.pertenece(gohan));
		assertTrue(guerreros.pertenece(piccolo));
	}
	
	@Test
	public void testCrearDosGuerrerosZIntegrantesDeUnEquipoNoPertenecenAlOtro() {
		GuerrerosZ guerreros1 = new GuerrerosZ(), guerreros2 = new GuerrerosZ();
		Unidad goku1 = guerreros1.getGoku(),
			   gohan1 = guerreros1.getGohan(), 
			   piccolo1 = guerreros1.getPiccolo();
		Unidad goku2 = guerreros2.getGoku(),
			   gohan2 = guerreros2.getGohan(), 
			   piccolo2 = guerreros2.getPiccolo();
		assertFalse(guerreros1.pertenece(goku2));
		assertFalse(guerreros1.pertenece(gohan2));
		assertFalse(guerreros1.pertenece(piccolo2));
		
		assertFalse(guerreros2.pertenece(goku1));
		assertFalse(guerreros2.pertenece(gohan1));
		assertFalse(guerreros2.pertenece(piccolo1));
	}

	@Test
	public void testObtenerIntegrantesDevuelveUnaListaUnicamenteConLosIntegrantes() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad goku = guerreros.getGoku(),
			   gohan = guerreros.getGohan(), 
			   piccolo = guerreros.getPiccolo();
		List<Unidad> integrantes = guerreros.integrantes();
		assertTrue(integrantes.contains(goku));
		assertTrue(integrantes.contains(gohan));
		assertTrue(integrantes.contains(piccolo));
		assertEquals(3, integrantes.size());
	}
	
	@Test
	public void testPasarTurnoHacePasarElTurnoATodosLosIntegrantes() {
		GuerrerosZ guerreros = new GuerrerosZ();
		Unidad goku = guerreros.getGoku(),
			   gohan = guerreros.getGohan(), 
			   piccolo = guerreros.getPiccolo();
		int kiAntesGoku = goku.getKi().getMagnitud();
		int kiAntesGohan = gohan.getKi().getMagnitud();
		int kiAntesPiccolo = piccolo.getKi().getMagnitud();
		guerreros.pasarTurno();
		assertEquals(5 + kiAntesGoku, goku.getKi().getMagnitud());
		assertEquals(5 + kiAntesGohan, gohan.getKi().getMagnitud());
		assertEquals(5 + kiAntesPiccolo, piccolo.getKi().getMagnitud());
	}
	
	@Test
	public void testEquipoEstaVivoAlCrear() {
		Equipo guerreros = new GuerrerosZ();
		assertTrue(guerreros.estaVivo());
	}
	
	@Test
	public void testEquipoNoEstaVivoAlMatarATodosSusPersonajes() {
		Equipo guerreros = new GuerrerosZ();
		for (Unidad integrante : guerreros.integrantes()) {
			integrante.recibirAtaque(new AtaqueBasico(integrante.getVida().getVidaMaxima() * 2));
		}
		assertFalse(guerreros.estaVivo());
	}
	
	@Test
	public void testNombreDelEquipoEsGuerrerosZ() {
		Equipo guerreros = new GuerrerosZ();
		assertEquals("Guerreros Z", guerreros.getNombre());
	}
}
