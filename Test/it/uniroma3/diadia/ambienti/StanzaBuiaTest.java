package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	StanzaBuia stanza;
	Attrezzo lanterna;
	Attrezzo attrezzoQualsiasi;
	String buioPesto="qui c'è buio pesto";

	@Before
	public void setUp() throws Exception {
		stanza=new StanzaBuia("stanza buia");
		attrezzoQualsiasi=new Attrezzo("statua",500);
		stanza.addAttrezzo(attrezzoQualsiasi);
		lanterna=new Attrezzo("lanterna",2);
	}

	@Test
	public void testStanzaBuiaSenzaLanterna() {
		assertEquals(buioPesto,stanza.getDescrizione());
		
	}
	@Test
	public void testStanzaBuiaConLanterna() {
		stanza.addAttrezzo(lanterna);
		assertNotEquals(buioPesto,stanza.getDescrizione());
		
	}
	
	

}
