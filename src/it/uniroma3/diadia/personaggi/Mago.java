package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
		StringBuilder msg = new StringBuilder();
		msg.append("Grazie per il regalo!! ecco a te");
		
		Attrezzo attrezzoAlleggerito = new Attrezzo(attrezzo.getNome(),attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoAlleggerito);
		
		return msg.toString();
	}
}