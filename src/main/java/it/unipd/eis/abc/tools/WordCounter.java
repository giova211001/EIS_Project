package it.unipd.eis.abc.tools;

import it.unipd.eis.abc.Article;
import it.unipd.eis.abc.analyze.Deserializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Classe che serve ad ottenere i 50 termini più frequenti dagli articoli precedentemente scaricati,
 * insieme al loro peso (ovvero il numero di documenti in cui appare)
 */
public class WordCounter {

    private static final String STOPLIST_FILE = "./assets/english_stoplist_v1.txt";
    private static final List<String> stopList = loadStopList();

    /**
     * Salva in un file txt i 50 termini più frequenti dagli articoli precedentemente scaricati,
     * insieme al loro peso (ovvero il numero di documenti in cui appare).
     */
    public static void getFrequency() {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        Article[] articles = new Article[] {};

        // reperisco gli articoli dal file JSON
        try {
            articles = Deserializer.JSON_to_Article("./assets/articles.json");
        } catch (FileNotFoundException e) {
            System.err.println("File JSON contenente gli articoli non trovato");
        }

        // conteggio parole piu' frequenti da articoli
        for (Article article: articles) {
            for(String word: getWords(article))
                // se la parola e' presente nella HashMap incrementa la frequenza di 1, senno' freq = 1
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        // salvataggio dei termini piu' importanti nel file di testo
        FileWriter writer;
        try {
            writer = new FileWriter("./assets/wordscount.txt");

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordFrequencyMap.entrySet());

            sortedList.sort((e1, e2) -> {
                if (e1.getValue().equals(e2.getValue())) // se i termini hanno la stessa frequenza
                    return e1.getKey().compareTo(e2.getKey());
                return e2.getValue().compareTo(e1.getValue()); // se hanno frequenza diversa
            });


            for (int i = 0; i < 50; i++)
                writer.write(sortedList.get(i).getKey() + " " + sortedList.get(i).getValue() + "\n");

            writer.close();

        } catch (IOException e) {
            System.err.println("Errore nel nome del file di output");
        }
    }

    /**
     * Ricava da un articolo l'insieme dei termini che lo compongono (senza ripetizioni)
     * @param article Articolo da cui estrarre i termini
     * @return insieme dei termini
     */
    private static Set<String> getWords(Article article) {

        Set<String> words = new HashSet<>();
        String toSplit = (article.getTitle() + " " + article.getBody()).toLowerCase();

        Collections.addAll(words, toSplit.split("[^a-z]+"));
        words.removeIf(stopList::contains); // rimuove dal set gli elementi presenti nella stopList
        words.remove(""); // rimuovo eventuali stringhe vuote aggiunte da split

        return words;
    }

    /**
     * Ricava da un file di testo una lista di parole da non includere nel conteggio
     * @return lista di parole (String) poco significative
     */
    private static List<String> loadStopList() {
        List<String> stopList = new ArrayList<>();

        try {
            File file = new File(STOPLIST_FILE);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
                stopList.add(scanner.nextLine());

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File contenente la stop list non trovato.");
        }
        return stopList;
    }



}
