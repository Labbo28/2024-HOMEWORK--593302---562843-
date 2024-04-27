package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
    private Stanza stanza;
    private Stanza stanzaNord;
    private Stanza stanzaSud;
    private Stanza stanzaEst;
    private Stanza stanzaOvest;
    
    private Attrezzo attrezzo1;
    private Attrezzo attrezzo2;
    private String[] direzioni;
   
   
    @Before
    public void setUp() throws Exception {
    	
    	direzioni=new String[4];
    	direzioni[0]="nord";
    	direzioni[1]="sud";
    	direzioni[2]="est";
    	direzioni[3]="ovest";
        stanza = new Stanza("stanza");
        stanzaNord = new Stanza("stanzaNord");
       
        
        stanza.impostaStanzaAdiacente("nord", stanzaNord);
        stanza.impostaStanzaAdiacente("sud", stanzaSud);
        stanza.impostaStanzaAdiacente("est", stanzaEst);
        stanza.impostaStanzaAdiacente("ovest", stanzaOvest);
            
        attrezzo1 = new Attrezzo("attrezzo1", 5);
        attrezzo2 = new Attrezzo("attrezzo2", 0);
        stanza.addAttrezzo(attrezzo1);
        stanza.addAttrezzo(attrezzo2);
        
        
    }

    @Test
    public void testGetNome() {
        assertEquals("stanza", stanza.getNome());
    }
    @Test
    public void testAddAttrezzo() {
    	Attrezzo attrezzo3=new Attrezzo("attrezzo3",4);
    	assertTrue(stanza.addAttrezzo(attrezzo3));
    }
    @Test
    public void testAggiuntaAttrezziOltreLimite() {
        Stanza stanza = new Stanza("Atrio");

        // Aggiungiamo 10 attrezzi alla stanza
        for (int i = 0; i < 10; i++) {
            Attrezzo attrezzo = new Attrezzo("attrezzo" + i, i);
            stanza.addAttrezzo(attrezzo);
        }

        // Ora proviamo ad aggiungere un altro attrezzo
        Attrezzo attrezzoExtra = new Attrezzo("attrezzoExtra", 10);
        boolean aggiunto = stanza.addAttrezzo(attrezzoExtra);

        // Verifichiamo che l'aggiunta sia fallita
        assertFalse(aggiunto);
        // Verifichiamo che il numero di attrezzi nella stanza sia ancora 10
        assertEquals(10, stanza.getNumeroAttrezzi());
    }
    
    @Test
    public void testStanzaAdiacenteImpostataCorrettamente() {
        assertEquals(stanzaNord, stanza.getStanzaAdiacente("nord"));
    }
    
    @Test
    public void testVerificaIncrementoNumeroStanzeAdiacenti() {
        assertEquals(4, stanza.getNumeroStanzeAdiacenti());
       
    }
    
    @Test
    public void testGetNumerottrezzi() {
    	assertEquals(2,stanza.getNumeroAttrezzi());
    }
    
    @Test
    public void testVerificaCorrettezzaDelMetodoToString() {
        assertEquals("stanza\nUscite:  nord sud est ovest\nAttrezzi nella stanza: attrezzo1 (5kg) attrezzo2 (0kg) ", stanza.getDescrizione());
    }
    
    @Test
    public void testVerificaEsistenzaDiUnAttrezzoNellaStanzaConOutputTrue() {
        assertTrue(stanza.hasAttrezzo("attrezzo1"));
    }
    
    @Test
    public void testVerificaNonEsistenzaDiUnAttrezzoNellaStanzaConOutputFalse() {
        assertFalse(stanza.hasAttrezzo("non_esistente"));
    }
    @Test
    public void testGetAttrezzoConAttrezzoEsistente() {
    	assertEquals(stanza.getAttrezzo("attrezzo1"),attrezzo1);
    }
    @Test
    public void testGetAttrezzoConAttrezzoNonEsistente() {
    	assertEquals(stanza.getAttrezzo("non_esistente"),null);
    }
    @Test
    public void  testGetAttrezzoConParmetroNull() {
    	assertEquals(stanza.getAttrezzo(null),null);
    }
    @Test
    public void tesGetDirezioni() {
        assertArrayEquals(direzioni, stanza.getDirezioni());
    }
    
    @Test
    public void testRemoveAttrezzoPresente() {
        assertTrue(stanza.removeAttrezzo(attrezzo1));
        for(Attrezzo attrezzo:stanza.getAttrezzi()) {
        	if(attrezzo!=null)
        	attrezzo.toString();
        	
        }
    }

    @Test
    public void testRemoveAttrezzoNonPresente() {
    	Stanza stanza = new Stanza("Stanza Test");

    	Attrezzo attrezzoNonPresente = new Attrezzo("non_presente", 10);
    	assertFalse(stanza.removeAttrezzo(attrezzoNonPresente));
    }
        
    @Test
    public void testRemoveAttrezzoStanzaVuota() {
        stanza.removeAttrezzo(attrezzo1);
        stanza.removeAttrezzo(attrezzo2);
        assertEquals(0, stanza.getNumeroAttrezzi());
        
    }


}
