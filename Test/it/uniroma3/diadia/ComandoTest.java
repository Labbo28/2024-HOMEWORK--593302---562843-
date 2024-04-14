package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComandoTest {
	
	Comando comando;

	@Before
	public void setUp() throws Exception {
		comando=new Comando("prendi");
	}

	@Test
	public void test() {
		assertFalse(comando.sconosciuto());
	}

}
