package it.uniroma3.diadia.comandi;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuardaOrdinatoPerNome implements Comando {
IOConsole console;

public ComandoGuardaOrdinatoPerNome () {
	console=new IOConsole();
}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 Set<Attrezzo> attrezziBorsa=borsa.getContenutoOrdinatoPerNome();
		 
		 console.mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa ordinato per Nome:");
		 if(borsa.getNumeroAttrezzi()==0)
			 console.mostraMessaggio("  la borsa è vuota");
		 else
			console.mostraMessaggio("\n"+attrezziBorsa.toString());
		 console.mostraMessaggio("\n");
		 
		
	}

	

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setIo(IO io) {
		this.console=(IOConsole) io;
		
	}
}
