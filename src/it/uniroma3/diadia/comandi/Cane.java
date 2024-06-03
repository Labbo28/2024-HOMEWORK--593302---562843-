package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class Cane extends AbstractPersonaggio{
	
	String nome="cane";
	String presentazione="wof wof wof";
	boolean haSalutato=false;
	

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
		
	}

	@Override
	public String agisci(Partita partita) {
		
		
		return null;	
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo , Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
