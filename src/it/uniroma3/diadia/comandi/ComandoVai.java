package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando {
private String direzione;
IO console;

public ComandoVai(String direzione) {
this.direzione = direzione;
console=new IOConsole();
}

/**
* esecuzione del comando
*/
@Override
public void esegui(Partita partita) {
	Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
	Stanza prossimaStanza=null;
	
	if(direzione==null) {
		 console.mostraMessaggio("dove vuoi andare? Devi specificare una direzione");
		return;
	}
	prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
	if(prossimaStanza==null) {
		 console.mostraMessaggio("Direzione inesistente");
		return;
	}
	
	partita.getLabirinto().setStanzaCorrente(prossimaStanza);
	 console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
  }
@Override
public void setParametro(String parametro) {
	this.direzione=parametro;
}
@Override
public void setIo(IO io) {
	this.console=io;
	
}

@Override
public String getParametro() {
	// TODO Auto-generated method stub
	return this.getParametro();
}

}