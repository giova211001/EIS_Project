package it.unipd.eis.abc;


import it.unipd.eis.abc.analyze.Deserializer;
import it.unipd.eis.abc.analyze.Serializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Classe per il controllo delle funzioni di serializzazione e deserializzazione
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SerializerDeserializerTest {


    /**
     * Metodo per il controllo del processo di serializzazione
     * Il metodo:
     * - crea una lista di articoli con titolo e corpo di esempio
     * - verifica che il metodo Article_to_JSON mi effettui la conversione da tipo Article a file JSON
     * - verifica che venga creato il file .json nella cartella assets
     */

    @Test
    @Order(1) //imposto ordine 1 perchè non posso deserializzare se prima non ho serializzato
    public void SerializeTest()
    {
        //Creo un array di articoli e lo serializzo (creo un file con estensione .json)
        Article[] articles = new Article[3];
        articles[0] = new Article("Titolo 1", "Body 1");
        articles[1] = new Article("Titolo 2", "Body 2");
        articles[2] = new Article("Titolo 3", "Body 3");

        //Li serializzo
        Serializer.Article_to_JSON(articles);

        //A questo punto dovrebbe esserci presente un file .json nella cartella asset
    }

    /**
     * Metodo per il controllo del processo di deserializzazione
     * Il metodo:
     * - verifica che sia presente il file .json nella cartella assets
     * - verifica che la deserializzazione avvenga correttamente conteggiando gli elementi che vengono salvati
     * in articles
     * - verifica che il contenuto degli articoli (title e body) sia corretto
     * @throws FileNotFoundException
     */

    @Test
    @Order(2)
    public void DeserializeTest() throws FileNotFoundException {
        //Prelevo il percorso del file .json presente in assets
        File file = new File("./assets/articles.json");
        //verifico che il file sia presente
        assertTrue(file.exists());

        //Deserializzo
        Article[] articles = Deserializer.JSON_to_Article("./assets/articles.json");
        //verifico che abbia deserializzato esattamente 3 articoli
        assertEquals(3, articles.length);
        //verifico che non sia nullo
        assertNotNull(articles);

        //Verifica del contenuto degli articoli
        // Verifica titolo del primo articolo
        String title1 = articles[0].getTitle();
        assertEquals("Titolo 1", title1);
        //Verifica corpo del terzo articolo
        String body3 = articles[2].getBody();
        assertEquals("Body 3", body3);

        //Elimino il file creato per il test
        file.delete();


    }
}
