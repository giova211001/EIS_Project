package it.unipd.eis.dei.analyze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import it.unipd.eis.dei.Article;

/**
 * Classe per deserializzare un file JSON in una lista di oggetti della classe Article
 */

public class Deserializer {

    /**
     * Metodo JSON_to_Article() prende una stringa JSON salvata in un file nella cartella assets
     * e tramite la libreria Gson fa la deserializzazione in una lista di oggetti di tipo Article e li
     * stampa a video
     * @param path, percorso del file che contiene la stringa JSON
     * @return Article[] articles, lista di oggetti di tipo Article
     * @see com.google.gson.Gson
     */
    public static Article[] JSON_to_Article(String path) throws FileNotFoundException {
        //prelevo il file che contiene la stringa JSON da deserializzare
        File json = new File(path);
        //per la lettura del file
        FileReader fr = new FileReader(json);
        //creo un oggetto di tipo Gson
        Gson gson = new Gson();
        //creo un tipo list_art che rappresenta un tipo di dato per la mia lista di Article
        //per ottenere lo stesso tipo per tutti gli oggetti della lista tramite il metodo .getType()
        Type list_art = new TypeToken<List<Article>>(){}.getType();
        //effettuo la deserializzazione tramite il metodo fromJson
        List<Article> articles = gson.fromJson(fr, list_art);
        //ritorno la lista di oggetti di tipo Article
        return articles.toArray(new Article[0]);

    }
}
