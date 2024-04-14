package it.uniroma3.diadia;




import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {
	
	
	

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole console;
	 

	public DiaDia(IOConsole console) {
		console=new IOConsole();
		this.console=console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
				
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			this.partita.giocatore.setCfu(cfu-1);
		}
		console.mostraMessaggio(partita.labirinto.getStanzaCorrente().getDescrizione());
	}
	
	/*
	 * Comando che permette all'utente di prendere un oggetto dalla stanza corrente
	 * e riporlo all'interno della propria borsa, verificando prima che l'oggetto esiste nella stanza corrente
	 * e che la borsa non abbia raggiunto la capacità massima 
	 */
	private void prendi(String nomeOggetto) {
		
	    if (nomeOggetto != null) {
	        Borsa borsa = this.partita.giocatore.getBorsa();
	       
	        if (borsa != null) {
	            Stanza stanzaCorrente = this.partita.labirinto.getStanzaCorrente();
	            Attrezzo attrezzoDaRaccogliere = stanzaCorrente.getAttrezzo(nomeOggetto);
	            if (attrezzoDaRaccogliere != null) {
	                if (borsa.addAttrezzo(attrezzoDaRaccogliere)) {
	                    stanzaCorrente.removeAttrezzo(attrezzoDaRaccogliere);
	                   
	                    console.mostraMessaggio("Hai raccolto l'oggetto " + nomeOggetto + " e lo hai aggiunto alla tua borsa.");
	                } else {
	                	console.mostraMessaggio("Non hai spazio sufficiente nella borsa per raccogliere l'oggetto.");
	                }
	            } else {
	            	console.mostraMessaggio("L'oggetto " + nomeOggetto + " non esiste in questa stanza.");
	            }
	        }
	    }
	}
	
	/*
	 * Comando che permette all'utente di prendere un oggetto dalla propria borsa
	 * e posarlo all'interno della stanza corrente, verificando prima che l'oggetto esiste nella borsa 
	 */
	private void posa(String nomeOggetto) {
	    if (nomeOggetto != null) {
	        Borsa borsa = this.partita.giocatore.getBorsa();
	        if (borsa != null) {
	            Stanza stanzaCorrente = this.partita.labirinto.getStanzaCorrente();
	            Attrezzo attrezzoDaPosare = borsa.getAttrezzo(nomeOggetto);
	            if (attrezzoDaPosare != null) {
	                if (stanzaCorrente != null && stanzaCorrente.getNumeroAttrezzi() < Stanza.getNumeroMassimoAttrezzi()) {
	                    Attrezzo attrezzoRimosso = borsa.removeAttrezzo(nomeOggetto);
	                    if (attrezzoRimosso != null) {
	                        stanzaCorrente.addAttrezzo(attrezzoRimosso);
	                        console.mostraMessaggio("Hai posato l'oggetto " + nomeOggetto + " nella stanza " + stanzaCorrente.getNome());
	                    } else {
	                    	console.mostraMessaggio("Non hai l'oggetto " + nomeOggetto + " nella tua borsa.");
	                    }
	                } else {
	                	console.mostraMessaggio("La stanza " + stanzaCorrente.getNome() + " ha raggiunto la capienza massima di oggetti.");
	                }
	            } else {
	            	console.mostraMessaggio("Non hai l'oggetto " + nomeOggetto + " nella tua borsa.");
	            }
	        }
	    }
	}





	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console=new IOConsole();   
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}