package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

    private static String nome="cane";
    private static String presentazione="wof wof wof, voglio l'osso!";
    private static String osso = "osso";
    private static String ringraziamento="Wof Wof, grazie per l'osso! Ecco a te!";
    private static String delusione="Wof Wof, non era quello che ti avevo chiesto! GRRRRR!";



    public Cane(String nome, String presentaz) {
        super(nome, presentaz);

    }

    @Override
    public String agisci(Partita partita) {
    String messaggio = presentazione;
    partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
    return messaggio;
    }

    @Override
    public String riceviRegalo(Attrezzo attrezzo , Partita partita) {
        if(attrezzo.getNome().equals(osso)) {
            partita.getStanzaCorrente().addAttrezzo(new Attrezzo("cacciavite", 2));
            return ringraziamento;
        }
        else {
            partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
            return delusione;
        }
    }


}