package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	IO console;
	public ComandoNonValido() {
		console=new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		 console.mostraMessaggio("Comando non valido!");

	}

	

	@Override
	public void setIo(IO io) {
		this.console=io;
		
	}

}
