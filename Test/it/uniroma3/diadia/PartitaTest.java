package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {

    private Partita partita;
    private Labirinto labirinto;
    @Before
    public void setUp() {
    	labirinto= new Labirinto();
        partita = new Partita(labirinto);
    }

    @Test
    public void testPartitaNonFinitaIniziale() {
        assertFalse(partita.isFinita());
    }

    @Test
    public void testPartitaVinta() {
        Labirinto labirinto = partita.getLabirinto();
       
        labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
        assertTrue(partita.vinta());
    }

    @Test
    public void testPartitaFinitaSenzaCFU() {
        Giocatore giocatore = partita.getGiocatore();
        giocatore.setCfu(0);
        assertTrue(partita.isFinita());
    }


    @Test
    public void testPartitaFinitaDopoSetFinita() {
        partita.setFinita();
        assertTrue(partita.isFinita());
    }
}