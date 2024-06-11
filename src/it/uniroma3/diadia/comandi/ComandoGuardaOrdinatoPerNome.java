package it.uniroma3.diadia.comandi;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuardaOrdinatoPerNome extends AbstractComando {


public ComandoGuardaOrdinatoPerNome () {
	
}
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente=partita.getLabirinto().getStanzaCorrente();
		 Borsa borsa=partita.getGiocatore().getBorsa();
		 Set<Attrezzo> attrezziBorsa=borsa.getContenutoOrdinatoPerNome();
		 
		 this.getIo().mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa ordinato per Nome:");
		 if(borsa.getNumeroAttrezzi()==0)
			 this.getIo().mostraMessaggio("  la borsa è vuota");
		 else
			 this.getIo().mostraMessaggio("\n"+attrezziBorsa.toString());
		 this.getIo().mostraMessaggio("\n");
		 
		
	}


}
