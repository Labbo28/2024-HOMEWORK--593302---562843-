package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePerPeso implements Comparator<Attrezzo> {
    @Override
    public int compare(Attrezzo attrezzo1, Attrezzo attrezzo2) {
        return Integer.compare(attrezzo1.getPeso(), attrezzo2.getPeso());
    }
}
