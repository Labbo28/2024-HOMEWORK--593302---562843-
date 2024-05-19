package it.uniroma3.diadia.comandi;

import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuardaRaggruppatoPerPeso implements Comando {
	IOConsole console;
	
	public ComandoGuardaRaggruppatoPerPeso() {
		console =new IOConsole(); 			
		}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 Map<Integer,Set<Attrezzo>> attrezziBorsa=borsa.getContenutoRaggruppatoPerPeso();
		 
		 console.mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa raggruppato per peso:");
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
