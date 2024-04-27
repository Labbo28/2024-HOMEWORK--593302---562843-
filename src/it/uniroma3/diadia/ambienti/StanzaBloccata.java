package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	private static String direzioneBloccataDefault="nord";
	private static String chiaveDefault="chiave";
	
	private String direzioneBloccata;
	private String chiave;
	
	
	public StanzaBloccata(String Nome) {
		this(Nome,direzioneBloccataDefault, chiaveDefault);
	}
	public StanzaBloccata(String nome,String direzione,String chiave) {
		super(nome);
		this.direzioneBloccata=direzioneBloccataDefault;
		this.chiave=chiave;
		
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	
	public Stanza getStanzaAdiacente(String direzione) {
		String bloccata="ti serve l'oggetto "+chiave+" per passare";
		
		if(direzione.equals(this.direzioneBloccata) && !this.hasAttrezzo(chiave)) {
			bloccata.toString();
			return this;
		}
		
		return super.getStanzaAdiacente(direzione);	
		
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder bloccata = new StringBuilder();
		bloccata.append( "Stanza bloccata nella direzione: "+ direzioneBloccata+
				"\nPrendi l'oggetto: " + chiave + " e posalo nella stanza");
		
		bloccata.append("\ndirezione disponibili: ");
		for(int i=0; i<this.getNumeroStanzeAdiacenti();i++) {
			if(this.getDirezioni()[i]!="nord")
				bloccata.append(this.getDirezioni()[i]+" ");
		}
		bloccata.append("\nattrezzi nella stanza: ");
		for(int i=0;i<this.getNumeroAttrezzi();i++) {
			bloccata.append(this.getAttrezzi()[i]);
		}

		if(!this.hasAttrezzo(chiave))
			return bloccata.toString();
		return super.getDescrizione();
	}
	
	

}
