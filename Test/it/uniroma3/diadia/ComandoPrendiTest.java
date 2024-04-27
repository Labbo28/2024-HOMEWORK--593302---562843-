package it.uniroma3.diadia;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

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
    Borsa borsa;
    Stanza stanza;
    Attrezzo sasso;
    Attrezzo tavolo;
    IO console;


    @Before
    public void setUp() throws Exception {
    	
        stanza = new Stanza("Sala Giochi");
        partita = new Partita();
        partita.labirinto.setStanzaCorrente(stanza);
        borsa=new Borsa();
        partita.giocatore.setBorsa(borsa);
        sasso=new Attrezzo("Sasso", 2);
        tavolo=new Attrezzo("Tavolo", 12);
        console =new IOConsole();
        
        
    }
     @Test
        public void testRaccogliSasso() {
            comando = new ComandoPrendi("Sasso");
            comando.setIO(console);
            stanza.addAttrezzo(sasso);
            comando.setParametro("Sasso");
            comando.esegui(partita);
            assertTrue(borsa.hasAttrezzo("Sasso"));
            assertFalse(stanza.hasAttrezzo("Sasso"));
        }
     @Test
        public void testRaccogliTavoloTroppoPesante() {
         comando = new ComandoPrendi("Tavolo");
         comando.setIO(console);
            stanza.addAttrezzo(tavolo);
            comando.setParametro("Tavolo");
            comando.esegui(partita);
            assertFalse(borsa.hasAttrezzo("Tavolo"));
            assertTrue(stanza.hasAttrezzo("Tavolo"));

        }
     @Test
        public void testRaccogliOggettoNonPresente() {
    	 
            comando = new ComandoPrendi("NonEsiste");
            comando.setIO(console);
            comando.setParametro("NonEsiste");
            comando.esegui(partita);
            assertFalse(borsa.hasAttrezzo("NonEsiste"));
        }


}
