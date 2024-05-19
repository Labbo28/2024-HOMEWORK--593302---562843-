package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 */

public class ComandoFine implements Comando {
	IO console;
	public ComandoFine() {
		console=new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		 
		console.mostraMessaggio("Grazie per aver giocato!!");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setIo(IO io) {
		// TODO Auto-generated method stub
		
	}

}
