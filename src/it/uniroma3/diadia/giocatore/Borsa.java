package it.uniroma3.diadia.giocatore;



import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.Configuratore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezzoPerNome;

public class Borsa {
	
    public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
    private int pesoMax;
    private List<Attrezzo> attrezzi;

    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }

    public Borsa(int pesoMax) {
    	
        this.pesoMax = pesoMax;
        this.attrezzi = new ArrayList<>(); 
        
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
            return false;
        
        return this.attrezzi.add(attrezzo);
        
    }
    
    public List<Attrezzo> getContenutoOrdinatoPerPeso() {
        List<Attrezzo> sortedList = new ArrayList<>(this.attrezzi);
        sortedList.sort(new ComparatorePerPeso());
        return sortedList;
    }
    
    public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
    	
        SortedSet<Attrezzo> contenutoOrdinatoPerNome = new TreeSet<>(new ComparatoreAttrezzoPerNome());
        contenutoOrdinatoPerNome.addAll(this.attrezzi);

        return contenutoOrdinatoPerNome;
    }
    
    public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> raggruppatoPerPeso = new HashMap<>();

        for (Attrezzo attrezzo : this.attrezzi) {
            int peso = attrezzo.getPeso();
            Set<Attrezzo> attrezziConLoStessoPeso = raggruppatoPerPeso.get(peso);
            if (attrezziConLoStessoPeso == null) {
                attrezziConLoStessoPeso = new HashSet<>();
                raggruppatoPerPeso.put(peso, attrezziConLoStessoPeso);
            }
            attrezziConLoStessoPeso.add(attrezzo);
        }

        return raggruppatoPerPeso;
    }

    SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
        SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(new ComparatorePerPeso());
        s.addAll(this.getAttrezzi());
        return s;
    }

    public int getPesoMax() {
        return pesoMax;
    }
    
    public int getNumeroAttrezzi() {
    	return this.attrezzi.size();
    }
    
    public List<Attrezzo> getAttrezzi() {
    	return this.attrezzi;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;
        	
        for(Attrezzo attrezzo:this.attrezzi) {
        	if(attrezzo.getNome().equals(nomeAttrezzo))
        		a=attrezzo;
        }
        return a;
    }
    public int getPeso() {
        int peso = 0;
        
        for(Attrezzo attrezzo:this.attrezzi) {
        	peso+=attrezzo.getPeso();
        }

        return peso;
    }

    public boolean isEmpty() {
        return this.attrezzi.isEmpty();
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;

        for(Attrezzo attrezzo:this.attrezzi) {
        	if(attrezzo.getNome().equals(nomeAttrezzo)) {
        		a=attrezzo;
        			this.attrezzi.remove(a);
        			return a;
        	}
        }
        return null;
    }
    
    public void setAttrezzi(List<Attrezzo> attrezzi) {
    	this.attrezzi=attrezzi;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.attrezzi.size(); i++)
                s.append(attrezzi.get(i).toString()).append(" ");
        } else
            s.append("Borsa vuota");
        return s.toString();
    }

    public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}

}
