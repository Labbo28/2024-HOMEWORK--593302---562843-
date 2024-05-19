package it.uniroma3.diadia.ambienti;



/**
 * Classe Labirinto-questa classe inizializza la mappa di gioco,
 * creando tutte quante le stnze che lo compongono e collegandole tra di esse
 * ,impostando la stanza corrente e la stanza vincente.
 * Si occupa anche della creazione degli oggetti e del loro posizionamento.
 * @author 593302,562843 
 * @see Stanza, Attrezzo
 * @version 1.0
 */

public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
	
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza vincente) {
		this.stanzaVincente=vincente;
		
	}
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	

}


