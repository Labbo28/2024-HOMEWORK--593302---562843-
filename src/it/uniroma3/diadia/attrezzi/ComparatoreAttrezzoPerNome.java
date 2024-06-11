package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezzoPerNome implements Comparator<Attrezzo> {

    @Override
    public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
        // Ordina gli attrezzi per nome in ordine alfabetico
        return attrezzo1.getNome().compareTo(attrezzo2.getNome());
    }
}
