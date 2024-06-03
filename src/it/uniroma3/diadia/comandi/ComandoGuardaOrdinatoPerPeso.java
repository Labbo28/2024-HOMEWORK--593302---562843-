package it.uniroma3.diadia.comandi;

import java.util.List;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuardaOrdinatoPerPeso extends AbstractComando{
	IOConsole console;

	
	public ComandoGuardaOrdinatoPerPeso() {
		console=new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 List<Attrezzo> attrezziBorsa=borsa.getContenutoOrdinatoPerPeso();
		 
		 console.mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa ordinato per peso:");
		 if(borsa.getNumeroAttrezzi()==0)
			 console.mostraMessaggio("  la borsa è vuota");
		 else
			 for(int i=0;i<borsa.getNumeroAttrezzi();i++) {
				 console.mostraMessaggio("["+attrezziBorsa.get(i)+"]");
		 }
		 console.mostraMessaggio("\n");
		 
		
	}

	
	@Override
	public void setIo(IO io) {
		this.console=(IOConsole) io;
		
	}
}
