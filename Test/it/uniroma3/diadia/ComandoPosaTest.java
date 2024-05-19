package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
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
	LabirintoBuilder LabBuilder;
	Labirinto labirinto;
	IO console;
	
	@Before
	public void setUp() throws Exception {
		attrezzo=new Attrezzo("pallina",1);
		LabBuilder=new LabirintoBuilder();
		labirinto=LabBuilder.getLabirinto();
		partita=new Partita(labirinto);
		console=new IOConsole();
	}

	@Test
	public void testGetParametro() {
		LabBuilder.addStanzaIniziale("stanza inziale").addAttrezzo("pallina", 1);
		comando=new ComandoPosa("pallina");
		comando.setIO(console);
		assertEquals("pallina",comando.getParametro());
		
	}
	
	@Test 
	public void testPosaOggettoPresenteNellaBorsa() {
		LabBuilder.addStanzaIniziale("stanza inziale");
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		
		comando=new ComandoPosa("pallina");
		comando.setIO(console);
		comando.esegui(partita);
		assertEquals(labirinto.getStanzaCorrente().getAttrezzo("pallina"),attrezzo);
	}
	
	public void testPosaOggettoNonPresenteNellaBorsa() {
		comando=new ComandoPosa("trapano");
		comando.setIO(console);
		comando.esegui(partita);
		assertNotEquals(stanza.getAttrezzo("trapano"),attrezzo);
		
	}

}
