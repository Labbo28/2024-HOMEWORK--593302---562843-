package it.uniroma3.diadia;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;


public class ComandoPrendiTest {
    Partita partita;
    ComandoPrendi comando;
    Labirinto labirinto;
    LabirintoBuilder LabBuilder;
    IO console;


    @Before
    public void setUp() throws Exception {
    	
    	LabBuilder=new LabirintoBuilder();
    	labirinto=LabBuilder.getLabirinto();
        partita = new Partita(labirinto);
        console =new IOConsole();
        
        
        
    }
     @Test
        public void testRaccogliSasso() {
    	 	LabBuilder.addStanzaIniziale("stanza inziale").addAttrezzo("Sasso", 2);
            comando = new ComandoPrendi("Sasso");
            comando.setIO(console);
            comando.setParametro("Sasso");
            comando.esegui(partita);
            assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("Sasso"));
            assertFalse(labirinto.getStanzaCorrente().hasAttrezzo("Sasso"));
        }
     @Test
        public void testRaccogliTavoloTroppoPesante() {
    	 
    	 LabBuilder.addStanzaIniziale("stanza inziale").addAttrezzo("Tavolo", 50);
    	 
         comando = new ComandoPrendi("Tavolo");
         comando.setIO(console);
            comando.setParametro("Tavolo");
            comando.esegui(partita);
            assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Tavolo"));
            assertTrue(labirinto.getStanzaCorrente().hasAttrezzo("Tavolo"));

        }
     @Test
        public void testRaccogliOggettoNonPresente() {
    	 LabBuilder.addStanzaIniziale("stanza inziale").addAttrezzo("penna",2);
            comando = new ComandoPrendi("NonEsiste");
            comando.setIO(console);
            comando.setParametro("NonEsiste");
            comando.esegui(partita);
            assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("NonEsiste"));
        }


}
