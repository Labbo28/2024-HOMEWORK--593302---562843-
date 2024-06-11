package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public class ComandoFine extends AbstractComando {
	
	public ComandoFine() {
	
	}
	public void esegui(Partita partita) {
		 
		this.getIo().mostraMessaggio("Grazie per aver giocato!!");

	}

	
	

}
