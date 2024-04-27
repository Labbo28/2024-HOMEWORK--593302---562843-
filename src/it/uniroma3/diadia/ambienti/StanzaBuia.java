package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
		private String luce="lanterna";
	public StanzaBuia(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
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
