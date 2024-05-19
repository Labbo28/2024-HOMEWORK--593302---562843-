package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
    private Borsa borsa;
   private List <Attrezzo> listaOrdinata;
   private List <Attrezzo> listaDisordinata;
   private Map<Integer, Set<Attrezzo>> mappa;

    @Before
    public void setUp() {
    	mappa=new HashMap<>();
    	listaOrdinata=new ArrayList<>();
    	listaDisordinata=new ArrayList<>();
        borsa = new Borsa();
        
        listaOrdinata.add(new Attrezzo("pesce",1));
        listaOrdinata.add(new Attrezzo("pistola",1));
        listaOrdinata.add(new Attrezzo("pennarello",3));
        
        listaDisordinata.add(new Attrezzo("pesce",1));
        listaDisordinata.add(new Attrezzo("pistola",1));
        listaDisordinata.add(new Attrezzo("pennarello",3));
    }
    @Test public void testGetContenutoRaggruppatoPerPeso() {
    	borsa.setAttrezzi(listaDisordinata);;
    	mappa.putAll(borsa.getContenutoRaggruppatoPerPeso());
    	
    	assertEquals(2,mappa.size());
    }

    @Test
    public void testAggiuntaAttrezzoConPesoMassimo() {
        assertTrue(borsa.addAttrezzo(new Attrezzo("Attrezzo", 5)));
    }

    @Test
    public void testAggiuntaAttrezzoConPesoTroppoGrande() {
        assertFalse(borsa.addAttrezzo(new Attrezzo("Attrezzo", 11)));
    }

    @Test
    public void testGetPesoMassimo() {
        assertEquals(10, borsa.getPesoMax());
    }

    @Test
    public void testBorsaVuotaAllInizio() {
        assertTrue(borsa.isEmpty());
    }
    @Test
    public void testGetContenutoOrdinatoPerPeso() {
    	borsa.setAttrezzi(listaDisordinata);
    	borsa.setAttrezzi(borsa.getContenutoOrdinatoPerPeso());
    	for(int i=0;i<3;i++) {
    		assertEquals(listaOrdinata.get(i),borsa.getAttrezzi().get(i));
    	}
    }

    @Test
    public void testHasAttrezzo() {
        Attrezzo attrezzo = new Attrezzo("Attrezzo", 2);
        borsa.addAttrezzo(attrezzo);
        assertTrue(borsa.hasAttrezzo("Attrezzo"));
    }

    @Test
    public void testToString() {
        Attrezzo penna = new Attrezzo("Attrezzo", 1);
        Attrezzo bloccoNote = new Attrezzo("Attrezzo2", 2);
        borsa.addAttrezzo(penna);
        borsa.addAttrezzo(bloccoNote);
        String expected = "Contenuto borsa (3kg/10kg): Attrezzo (1kg) Attrezzo2 (2kg) ";
        assertEquals(expected, borsa.toString());
    }
    @Test
    public void testRemoveAttrezzoPresente() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo1 = new Attrezzo("Attrezzo1", 1);
        Attrezzo attrezzo2 = new Attrezzo("Attrezzo2", 2);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);

        Attrezzo attrezzoRimosso = borsa.removeAttrezzo("Attrezzo1");

        assertNotNull(attrezzoRimosso);
        assertEquals("Attrezzo1", attrezzoRimosso.getNome());
       
    }
    @Test
    public void testRemoveAttrezzoNonPresente() {
        Borsa borsa = new Borsa();
        Attrezzo attrezzo1 = new Attrezzo("Attrezzo1", 1);
        Attrezzo attrezzo2 = new Attrezzo("Attrezzo1", 2);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);

        Attrezzo attrezzoRimosso = borsa.removeAttrezzo("Attrezzo3");

        assertNull(attrezzoRimosso);
    }
}
