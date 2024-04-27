package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	Partita partita;
	ComandoPosa comando;
	Borsa borsa;
	Stanza stanza;
	Attrezzo attrezzo;
	IO console;
	
	@Before
	public void setUp() throws Exception {
		stanza=new Stanza("Sala giochi");
		partita=new Partita();
		partita.labirinto.setStanzaCorrente(stanza);
		borsa=new Borsa();
		partita.giocatore.setBorsa(borsa);
		attrezzo=new Attrezzo("pallina",4);
		borsa.addAttrezzo(attrezzo);
		console=new IOConsole();
	}

	@Test
	public void testGetParametro() {
		comando=new ComandoPosa("pallina");
		comando.setIO(console);
		
		assertEquals("pallina",comando.getParametro());
		
	}
	
	@Test 
	public void testPosaOggettoPresenteNellaBorsa() {
		comando=new ComandoPosa("pallina");
		comando.setIO(console);
		comando.esegui(partita);
		assertEquals(stanza.getAttrezzo("pallina"),attrezzo);
	}
	
	public void testPosaOggettoNonPresenteNellaBorsa() {
		comando=new ComandoPosa("trapano");
		comando.setIO(console);
		comando.esegui(partita);
		assertNotEquals(stanza.getAttrezzo("trapano"),attrezzo);
		
	}

}
