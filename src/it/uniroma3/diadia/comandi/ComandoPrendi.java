package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
/*
 * Comando che permette all'utente di prendere un oggetto dalla stanza corrente
 * e riporlo all'interno della propria borsa, verificando prima che l'oggetto esiste nella stanza corrente
 * e che la borsa non abbia raggiunto la capacità massima 
 */
public class ComandoPrendi implements Comando {
	String nomeOggetto;
	IO console;
	
		public ComandoPrendi(String nomeOggetto) {
			this.nomeOggetto=nomeOggetto;
			console=new IOConsole();
			
			
		}
	@Override
	public void esegui(Partita partita) {
		if (nomeOggetto != null) {
	        Borsa borsa = partita.getGiocatore().getBorsa();
	       
	        if (borsa != null) {
	            Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
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

	@Override
	public void setParametro(String parametro) {
		this.nomeOggetto=parametro;

	}
	
	public void setIO(IO io) {
		this.console=io;
	}
	@Override
	public void setIo(IO io) {
		this.console=io;
		
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeOggetto;
	}

	
	

}
