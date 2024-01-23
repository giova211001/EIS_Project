package it.unipd.eis.abc;

import it.unipd.eis.abc.tools.WordCounter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Classe di Test per WordCounter - controllo che vengano ottenuti correttamente i 50 termini più frequenti tra
 * tutti gli articoli presenti
 */
public class WordCounterTest {

    @AfterAll
    static void cleanUp() {
        assertTrue(new File("./assets/wordscount.txt").delete());
    }

    /**
     * Test che controlla se le parole e la frequenza di esse siano corrette
     */
    @Test
    public void countTest() {
        // articolo di test
        Article[] articles = new Article[5];
        articles[0] = new Article("prova uno due tre quattro", "prova due", null);
        articles[1] = new Article("uno due tre quattro", "uno tre quattro", null);
        articles[2] = new Article("uno due tre", "tre", null);
        articles[3] = new Article("uno due", "due", null);
        articles[4] = new Article("uno", "", null);

        // mappa contenente le parole e le relative frequenze effettive
        Map<String, Integer> manualMap = new HashMap<>();
        manualMap.put("uno", 5);
        manualMap.put("due", 4);
        manualMap.put("tre", 3);
        manualMap.put("quattro", 2);
        manualMap.put("prova", 1);

        WordCounter.getFrequency(articles);

        assertEquals(manualMap, this.counterFileToMap());

    }

    /**
     * Test per controllare che le parole da escludere siano effettivamente state immesse alla
     * lista stopList e che venga escluso il conteggio di esse
     */
    @Test
    public void stopListTest() {

        // controllo che alcune parole del file english_stoplist_v1.txt siano state aggiunte correttamente
        assertTrue(WordCounter.stopList.contains("a"));
        assertTrue(WordCounter.stopList.contains("later"));
        assertTrue(WordCounter.stopList.contains("zero"));

        // controllo che alcune parole casuali presenti nella lista non vengano contate
        Random random = new Random();
        int size = WordCounter.stopList.size();

        Article[] articles = new Article[] {
                new Article(WordCounter.stopList.get(random.nextInt(size)), "", ""),
                new Article(WordCounter.stopList.get(random.nextInt(size)), "", ""),
                new Article(WordCounter.stopList.get(random.nextInt(size)), "", "")
        };

        WordCounter.getFrequency(articles);
        assertEquals(new HashMap<>(), this.counterFileToMap());
    }

    /**
     * Controllo che l'ordine in cui i termini vengono salvati (con il relativo peso) sia corretto,
     * ovvero prima i termini con maggiore frequenza - in caso di termini con stessa frequenza
     * l'ordine è alfabetico
     */
    @Test
    public void orderTest() {
        // articolo di test
        Article[] articles = new Article[] {
                new Article("aaaa", "cccc", ""),
                new Article("cccc", "bbbb", ""),
                new Article("bbbb", "", "")
        };
        WordCounter.getFrequency(articles);

        // controllo l'ordine dei termini direttamente dal file di output
        try {
            Scanner scanner = new Scanner(new File("./assets/wordscount.txt"));

            assertEquals("bbbb 2", scanner.nextLine());
            assertEquals("cccc 2", scanner.nextLine());
            assertEquals("aaaa 1", scanner.nextLine());

            scanner.close();
        }
        catch (IOException e) {
            System.err.println("Errore nel nome del file di input");
        }
    }


    /**
     * Metodo ausiliario per salvare le parole e frequenze ottenute tramite WordCounter.getFrequency()
     * in una mappa
     * @return mappa contenente le parole degli articoli e la loro frequenza
     */
    private Map<String, Integer> counterFileToMap() {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File("./assets/wordscount.txt"));

            while (scanner.hasNextLine()) {
                wordFrequencyMap.put(scanner.next(), Integer.parseInt(scanner.next()));
                scanner.nextLine();
            }

            scanner.close();
        }
        catch (IOException e) {
            System.err.println("Errore nel nome del file di input");
        }
        return wordFrequencyMap;
    }

}
