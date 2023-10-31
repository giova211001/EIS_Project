package it.unipd.eis.abc.sources;

import it.unipd.eis.abc.Article;

import java.io.File;
import java.util.ArrayList;

/**
 * Classe per gestire gli articoli di NYTimes da file CSV presenti in nytimes_articles_v2.csv
 * Ogni file CSV è formato da 4 parametri:
 * - Identifier
 * - Url
 * - Title
 * - Body
 * - Date
 * - Source
 * - Set
 * - Source
 *
 * Implementazione:
 * Prelevo il file dal path e creo un nuovo oggetto Article per salvare tutti gli articoli presenti nel file
 */
public class CSV {

    //percorso del file
    private String path_file;

    //Lista di articoli per poterli salvare
    private ArrayList<Article> articles = new ArrayList<Article>();

    //Costruttore di classe
    public CSV(String path_file)
    {
        this.path_file = path_file;
    }

    //metodo per recuperare gli articoli dal file CSV
    //TODO inserire Article[] al posto di void, l'ho messo solo affinchè non dia errore
    public void getArticles()
    {
        //rappresenta tutti i file presenti nella directory del path_file
        File[] files = new File(path_file).listFiles();
        if(files != null && files.length != 0)
        {
            for(File f : files)
            {

            }
        }
    }


}
