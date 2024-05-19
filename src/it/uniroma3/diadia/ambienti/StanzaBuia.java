package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
		private static String luce="lanterna";
	public StanzaBuia(String nome) {
		this(nome,luce);
	}
	
	public StanzaBuia(String nome, String luce2) {
		super(nome);
		StanzaBuia.luce=luce2;
	}

	@Override
	public String getDescrizione() {
		String buioPesto="qui c'è buio pesto";
		if(this.hasAttrezzo(luce))
			return this.toString();
		else
			return buioPesto.toString(); 
			
		
	}

}
