package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
    private Borsa borsa;

    @Before
    public void setUp() {
        borsa = new Borsa();
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
