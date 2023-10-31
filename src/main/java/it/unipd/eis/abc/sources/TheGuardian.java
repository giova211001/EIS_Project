package it.unipd.eis.abc.sources;

import it.unipd.eis.abc.Article;

import java.util.ArrayList;

/**
 * Classe per la gestione degli articoli provenienti dal The Guardian
 */
public class TheGuardian {

    //impostazione dell'URL del The Guardian
    private static String GUARDIAN_URL = "http://content.guardianapis.com/search";

    //array di oggetti della classe Article
    public ArrayList<Article> articles = new ArrayList<Article>();

    //chiave privata per accedere alle API
    //la chiave va modificata con la chiave ottenuta dal sito The Guardian
    private String api_key = "test";

    //Costruttore della classe
    public TheGuardian()
    {

    }

    /**
     * Metodo per effettuare la richiesta alle API di TheGuardian
     * @return la richiesta effettuata al TheGuardian
     */



}
