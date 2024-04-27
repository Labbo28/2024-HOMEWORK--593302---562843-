package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

StanzaBloccata bloccata;
Stanza stanza;
Attrezzo chiave;


@Before
public void setUp() throws Exception {
    stanza = new Stanza("Stanza non bloccata");
    bloccata = new StanzaBloccata("Stanza Bloccata");
    chiave = new Attrezzo("chiave", 2);
    bloccata.impostaStanzaAdiacente("nord", stanza);
}

@Test
public void testgetStanzaAdiacenteSenzaChiave(){
    assertEquals(bloccata, bloccata.getStanzaAdiacente("nord"));
}

@Test
public void testgetStanzaAdiacenteConChiave(){
	bloccata.addAttrezzo(chiave);
    assertEquals(stanza, bloccata.getStanzaAdiacente("nord"));
	}

}