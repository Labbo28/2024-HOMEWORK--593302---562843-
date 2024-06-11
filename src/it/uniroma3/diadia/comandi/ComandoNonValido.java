package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {

	public ComandoNonValido() {
		
	}
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando non valido!");

	}

	


}
