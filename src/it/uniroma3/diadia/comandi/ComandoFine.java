package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public class ComandoFine extends AbstractComando {
	IO console;
	public ComandoFine() {
		console=new IOConsole();
	}
	public void esegui(Partita partita) {
		 
		console.mostraMessaggio("Grazie per aver giocato!!");

	}

	
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		
	}
	

}
