package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

	
	private boolean finita;
	
	public Labirinto labirinto;
	public Giocatore giocatore;
	
	public Partita(){
		giocatore=new Giocatore();
		labirinto=new Labirinto();
		this.finita = false;
		
	}

    
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Giocatore getGiocatore() {
		return this.giocatore;
	}



	public boolean giocatoreIsVivo() {
		Giocatore giocatore =this.giocatore;
		
		return giocatore.getCfu()>0;
	}

	

}
