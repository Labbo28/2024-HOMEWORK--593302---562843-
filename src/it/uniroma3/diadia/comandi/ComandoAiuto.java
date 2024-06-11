package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */
public class ComandoAiuto extends AbstractComando {

	public ComandoAiuto() {
		
	}
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};
	@Override
	public void esegui(Partita partita) {
		for(int i=0;i<elencoComandi.length;i++) {
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
			
		}
		this.getIo().mostraMessaggio("\n");
	}



}
