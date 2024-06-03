package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{
private Labirinto labirinto;
private Map<String,Stanza> mappa;
private Stanza ultimaStanza;

public LabirintoBuilder() {
	labirinto=new Labirinto();
	mappa=new HashMap<>();
}

public Map<String,Stanza> getListaStanze(){
	return this.mappa;
}

public Labirinto getLabirinto () {
	return this.labirinto;
}

public  LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza inziale =new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(inziale);
		this.aggiornaUltimaStanzaAggiunta(inziale);
		return this;
}

public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
	Stanza vincente =new Stanza(stanzaVincente);
	this.labirinto.setStanzaVincente(vincente);
	this.aggiornaUltimaStanzaAggiunta(vincente);
	return this;
}

public LabirintoBuilder addStanza(String stanza) {
	Stanza s =new Stanza(stanza);
	this.aggiornaUltimaStanzaAggiunta(s);
	return this;
	}

public LabirintoBuilder addStanzaMagica(String stanzaMagica,int sogliaMagica) {
	Stanza magica =new StanzaMagica(stanzaMagica,sogliaMagica);
	
	this.aggiornaUltimaStanzaAggiunta(magica);
	return this;
	}

public LabirintoBuilder addStanzaBloccata(String stanzaBloccata,String direzione,String oggettoSbloccante) {
	Stanza bloccata =new StanzaBloccata(stanzaBloccata,direzione,oggettoSbloccante);
	this.aggiornaUltimaStanzaAggiunta(bloccata);
	return this;
	}

public LabirintoBuilder addStanzaBuia(String stanzaBuia,String luce) {
	Stanza Buia =new StanzaBuia(stanzaBuia,luce);
	this.aggiornaUltimaStanzaAggiunta(Buia);
	return this;
	}

public LabirintoBuilder addAttrezzo(String nome,int peso) {
	if(ultimaStanza!=null) {
		Attrezzo attrezzo=new Attrezzo(nome,peso);
		this.ultimaStanza.addAttrezzo(attrezzo);
	}	
	return this;
	
}


public LabirintoBuilder addAdiacenza(String StanzaCorrente,String stanzaAdiacente ,String direzione){
	Stanza Corrente=this.mappa.get(StanzaCorrente);
	Stanza Adiacente=this.mappa.get(stanzaAdiacente);
	Corrente.impostaStanzaAdiacente(direzione, Adiacente);
	
	return this;
}

	

public void aggiornaUltimaStanzaAggiunta(Stanza stanza) {
	this.ultimaStanza=stanza;
	this.mappa.put(stanza.getNome(),stanza);
	
}

}
