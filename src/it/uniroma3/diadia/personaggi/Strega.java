import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		}
	
	@Override
	public String agisci(Partita partita) {
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAttrezzi = stanzeAdiacenti.get(0);
		Stanza minAttrezzi = stanzeAdiacenti.get(0);

		for(Stanza s : stanzeAdiacenti) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAttrezzi.getNumeroAttrezzi())
					maxAttrezzi = s;
				if(s.getNumeroAttrezzi() < minAttrezzi.getNumeroAttrezzi())
					minAttrezzi = s;
			}
		}
		
		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAttrezzi);
			return "Mi hai salutato! Ti porterò nella stanza con più attrezzi!";
		} else {
			partita.setStanzaCorrente(minAttrezzi);
			return "Non mi hai salutato! Ti porterò alla stanza con meno attrezzi!";
		}
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "ahahahahahahah";
	}
}
