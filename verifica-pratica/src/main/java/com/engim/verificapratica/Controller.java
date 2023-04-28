package com.engim.verificapratica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private static Sorteggio sorteggio = new Sorteggio();

    // ES1
    @GetMapping(value="/add")
    public void aggiungiNome(@RequestParam(value="nome")String nome,@RequestParam(value="nazione")String nazione){
        sorteggio.aggiungi(nome,nazione);
    }

    @GetMapping("/listaSquadre")
    public List<Squadra> listaSquadre(@RequestParam(value="nazione") String n){
        List<Squadra> nomiConS = new ArrayList<>();
        List<Squadra> nomi = sorteggio.getSquadre();
        for(Squadra nome : nomi){
            if(nome.getNazione()==n)
                nomiConS.add(nome);
        }
        return nomiConS;
    }

    @GetMapping("/sorteggia")
    public List<Squadra> sorteggia(){
        List<Squadra> nomiConS = new ArrayList<>();
        List<Squadra> nomi = sorteggio.getSquadre();
        for(Squadra nome : nomi){

            if(nome.getNazione()!=)
                for(int i = 0; i<2; i++){
                    nomiConS.add(sorteggio.next());
                }
        }

        return nomiConS;
    }





    /*
    * ES 1: get ("/add?nome=n&nazione=m") che aggiunge al sorteggio una squadra con nome n e nazione m (utilizzare
    * la classe Sorteggio) - 15 p
    *
    * ES 2: get ("/listaSquadre?nazione=n") che restituisce la lista delle squadre di nazione n - 20 p
    *
    * ES 3: get ("/sorteggia") che restituisce 2 squadre di nazioni diverse (utilizzare la classe Sorteggio, il metodo
    * next. Consiglio: dopo aver sorteggiato la prima, continuare a sorteggiare finché la seconda
    * non è di una nazione diversa) - 20 p
    *
    * ES 4: implementare il sorteggio delle squadre di una fase finale di un torneo a eliminazione diretta.
    * Creare il metodo sorteggiaPartite che:
    * - controlla se il numero di squadre aggiunte è una potenza di 2. Se non lo è lancia una RuntimeException.
    * - Finché ci sono squadre non sorteggiate: sorteggia 2 squadre e le inserisce in un oggetto della classe Partita (da creare)
    * - restituisce la lista di Partite.
    * creare get ("/getPartite") che restituisce la lista appena creata - 30 p
    * */

}
