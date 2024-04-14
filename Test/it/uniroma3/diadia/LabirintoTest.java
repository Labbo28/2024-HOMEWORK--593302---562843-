package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
    private Labirinto labirinto;

    @Before
    public void setUp() {
        labirinto = new Labirinto();
    }

    @Test
    public void testGetStanzaVincente() {
        Stanza stanzaVincente = labirinto.getStanzaVincente();
        assertNotNull(stanzaVincente);
        assertEquals("Biblioteca", stanzaVincente.getNome());
    }

    @Test
    public void testGetSetStanzaCorrente() {
        Stanza stanzaIniziale = labirinto.getStanzaCorrente();
        assertNotNull(stanzaIniziale);
        assertEquals("Atrio", stanzaIniziale.getNome());

        Stanza nuovaStanza = new Stanza("Nuova Stanza");
        labirinto.setStanzaCorrente(nuovaStanza);

        Stanza stanzaCorrente = labirinto.getStanzaCorrente();
        assertNotNull(stanzaCorrente);
        assertEquals("Nuova Stanza", stanzaCorrente.getNome());
    }
}