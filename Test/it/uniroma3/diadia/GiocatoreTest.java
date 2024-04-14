package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	Giocatore giocatore;
	Borsa borsa;

	@Before
	public void setUp() throws Exception {
		giocatore=new Giocatore();
		giocatore.setCfu(20);
		borsa=new Borsa();
		giocatore.setBorsa(borsa);
	}

	@Test
	public void testGetCfu() {
		assertEquals(20,giocatore.getCfu());
		
	}
	@Test
	public void testGetBorsa() {
		assertEquals(borsa,giocatore.getBorsa());
		
	}
	@Test
	public void testSetCfu() {
		giocatore.setCfu(0);
		assertEquals(0,giocatore.getCfu());
		
	}

}
