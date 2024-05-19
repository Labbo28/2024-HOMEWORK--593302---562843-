package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto implements Comando {
	IO console;
	public ComandoAiuto() {
		console=new IOConsole();
	}
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	@Override
	public void esegui(Partita partita) {
		for(int i=0;i<elencoComandi.length;i++) {
			 console.mostraMessaggio(elencoComandi[i]+" ");
			
		}
		 console.mostraMessaggio("\n");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIo(IO io) {
		this.console=io;
		
	}

}
