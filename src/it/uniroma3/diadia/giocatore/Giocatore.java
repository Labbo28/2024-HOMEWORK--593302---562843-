package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configuratore;

/**
 * Classe Giocatore-questa classe ha il compito di gestire i cfu del giocatore
 * e di fornire al giocatore una borsa
 * @author 593302,562843 
 * @see Borsa
 * @version 1.0
 */
public class Giocatore {
	static final private int CFU_INIZIALI = Configuratore.getCFU();
	int cfu;
	private Borsa borsa;
	
	/*il Giocatore comincia a giocare con CFU_INIZIALI cfu
	 * e riceve una borsa */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		setBorsa(new Borsa());
		
	}
	/* restituisce i cfu del giocatore*/
	public int getCfu() {
		return this.cfu;
	}
	/* imposta i cfu del giocatore*/
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	/* restituisce la borsa del giocatore*/
	public Borsa getBorsa() {
		return this.borsa;
	}
	/* imposta la borsa del giocatore*/
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

}
