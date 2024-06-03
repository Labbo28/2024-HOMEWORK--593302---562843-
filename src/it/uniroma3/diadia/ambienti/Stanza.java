package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private List <Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio;
	
	

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti=new HashMap<>();
		this.attrezzi = new ArrayList<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */
	void impostaStanzaAdiacente(String direzione,Stanza stanzaAdiacente) {
		if(this.stanzeAdiacenti.size()<4)
			this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
			}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
		}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}
	/**
	 * Restituisce il numero di stanze
	 *  adiacenti della stanza.
	 * @return il numero di stanze adiacenti
	 */
	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();

	}
	/**
	 * Restituisce il numero di attrezzi
	 * presenti nella stanza.
	 * @return il numero di attrezzi nella stanza
	 */
	public int getNumeroAttrezzi() {
		return this.attrezzi.size(); 

	}
	/**metodo setter per il numero di attrezzi nella stanza
	 * @param il numero di attrezzi che andrà a sovrascrivere il precendente
	 */
	
	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List <Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.attrezzi.size() < getNumeroMassimoAttrezzi() && attrezzo!=null){
			for(Attrezzo a:this.attrezzi) {
				if(a.equals(attrezzo))
					return false;
					}
					
			this.attrezzi.add(attrezzo);
				return true;
		}
		else 
			return false;
		
	}
	
	@Override
public boolean equals(Object o) {
		Stanza that=(Stanza)o;
		
		return this.getNome().equals(that.getNome());
		
	} 

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");

		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo != null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
			for(Attrezzo attrezzo:this.attrezzi) {
				if(attrezzo.getNome().equals(nomeAttrezzo))
					return true;
			}
		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato=null;
		
		for (Attrezzo Attrezzo : this.attrezzi) {
			if (Attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = Attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
			return (this.attrezzi.remove(attrezzo));	
	}



	public Set <String> getDirezioni() {
		 
		return this.stanzeAdiacenti.keySet();
	}

	public static int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}

	public Collection<Stanza> getStanzeAdiacenti() {
		return this.stanzeAdiacenti.values();
	}

	public void setStanzeAdiacenti(Map <String,Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	public Map <String,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}

	public void setPersonaggio(AbstractPersonaggio ap) {
        this.personaggio = ap;
    }

    public AbstractPersonaggio getPersonaggio() {
        return this.personaggio;
    }
}