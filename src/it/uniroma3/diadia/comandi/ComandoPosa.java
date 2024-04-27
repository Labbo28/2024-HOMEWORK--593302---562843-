package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
/*
 * Comando che permette all'utente di prendere un oggetto dalla propria borsa
 * e posarlo all'interno della stanza corrente, verificando prima che l'oggetto esiste nella borsa 
 */

public class ComandoPosa implements Comando {
	String nomeOggetto;
	IO console;
	
	public ComandoPosa(String nomeOggetto) {
		this.nomeOggetto=nomeOggetto;
		console=new IOConsole();
		
	}
	
	@Override
	public void esegui(Partita partita) {
		 if (nomeOggetto != null) {
		        Borsa borsa = partita.giocatore.getBorsa();
		        if (borsa != null) {
		            Stanza stanzaCorrente = partita.labirinto.getStanzaCorrente();
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

	@Override
	public void setParametro(String parametro) {
		this.nomeOggetto=parametro;

	}
	public String getParametro() {
		return this.nomeOggetto;
	}
	
	public void setIO(IO io) {
		this.console=io;
	}


}
