package it.unipd.eis.abc.analyze;

import com.fasterxml.jackson.databind.SerializationFeature;
import it.unipd.eis.abc.Article;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Classe per serializzare gli articoli, ovvero mappare un insieme di oggetti di tipo
 * Article in un file JSON
 */
public class Serializer {

    /**
     * Metodo Article_to_JSON() che converte un insieme di oggetti di tipo Article in un file con
     * estensione .json e lo inserire nella cartella assets
     * @param articles Array con tutti gli articoli presenti da tutte le sorgenti
     * @see com.fasterxml.jackson.databind.ObjectMapper
     */
    public static void Article_to_JSON(Article[] articles)
    {
        //controllo che array non sia nullo o non abbia dimensione uguale a zero
        if(articles.length != 0 && articles != null)
        {
            try
            {
                //creo un nuovo oggetto di tipo ObjectMapper
                ObjectMapper obj = new ObjectMapper();
                //metodo per visualizzare la stringa output in modo più leggibile
                obj.configure(SerializationFeature.INDENT_OUTPUT, true);
                //serializzo e scrivo il valore del JSON in un nuovo file di nome articles.json
                obj.writeValue(new File("./assets/articles.json"), articles);

            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            // messaggio di errore nel caso non trovassi gli articoli o l'array abbia dimensione nulla
            System.err.println("Articles[] articles vuoto o non disponibile");
            System.exit(1);
        }
    }

}
