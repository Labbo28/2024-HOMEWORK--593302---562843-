package it.uniroma3.diadia.comandi;

import java.util.List;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuarda extends AbstractComando {
	IO console;
	
	public ComandoGuarda() {
		console=new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		 Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 List<Attrezzo> attrezziBorsa=borsa.getAttrezzi();
		 
		 
		 console.mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa:");
		 if(borsa.getNumeroAttrezzi()==0)
			 console.mostraMessaggio("  la borsa è vuota");
		 else
			 for(int i=0;i<borsa.getNumeroAttrezzi();i++) {
				 console.mostraMessaggio("["+attrezziBorsa.get(i)+"]");
		 }
		 console.mostraMessaggio("\n");
		 console.mostraMessaggio("CFU rimanenti: "+partita.getGiocatore().getCfu());

	}

		

	@Override
	public void setIo(IO io) {
		this.console=io;
		
	}
}
