package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoGuarda implements Comando {
	IO console;
	
	public ComandoGuarda() {
		console=new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		 Stanza stanzaCorrente=partita.labirinto.getStanzaCorrente();
		 Borsa borsa=partita.giocatore.getBorsa();
		 Attrezzo[] attrezziBorsa=borsa.getAttrezzi();
		 
		 
		 console.mostraMessaggio(stanzaCorrente.getDescrizione()+"\nContenuto borsa:");
		 if(borsa.getNumeroAttrezzi()==0)
			 console.mostraMessaggio("  la borsa è vuota");
		 else
			 for(int i=0;i<borsa.getNumeroAttrezzi();i++) {
				 System.out.println("["+attrezziBorsa[i]+"]");
		 }
		 console.mostraMessaggio("\n");
		 console.mostraMessaggio("CFU rimanenti: "+partita.giocatore.getCfu());

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

}
