package it.uniroma3.diadia.ambienti;

import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	private static String direzioneBloccataDefault="nord";
	private static String chiaveDefault="chiave";
	
	private String direzioneBloccata;
	private String chiave;
	
	
	public StanzaBloccata(String Nome) {
		this(Nome,direzioneBloccataDefault, chiaveDefault);
	}
	public StanzaBloccata(String nome,String direzione,String chiave) {
		super(nome);
		this.direzioneBloccata=direzioneBloccataDefault;
		this.chiave=chiave;
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	
	public Stanza getStanzaAdiacente(String direzione) {
		String bloccata="ti serve l'oggetto "+chiave+" per passare";
		
		if(direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(chiave)) {
			bloccata.toString();
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);	
		
	}
	
	@Override
	public String getDescrizione() {
	    StringBuilder bloccata = new StringBuilder();
	    
	    // Ottieni le direzioni adiacenti come un set
	    Set<String> direzioni = this.getDirezioni();

	    bloccata.append("Stanza bloccata nella direzione: ").append(direzioneBloccata)
	            .append("\nPrendi l'oggetto: ").append(chiave).append(" e posalo nella stanza");
	    
	    bloccata.append("\nDirezioni disponibili: ");
	    for (String direzione : direzioni) {
	        if (!direzione.equals("nord")) {
	            bloccata.append(direzione).append(" ");
	        }
	    }
	    
	    bloccata.append("\nAttrezzi nella stanza: ");
	    for (Attrezzo attrezzo : this.getAttrezzi()) {
	        bloccata.append(attrezzo.getNome()).append(" ");
	    }

	    if (!this.hasAttrezzo(chiave)) {
	        return bloccata.toString();
	    }
	    
	    return super.getDescrizione();
	}

	
	

}
