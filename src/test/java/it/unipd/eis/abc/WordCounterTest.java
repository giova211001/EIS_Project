package it.unipd.eis.abc;

import it.unipd.eis.abc.tools.WordCounter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordCounterTest {

    @AfterAll
    static void cleanUp() {
        assertTrue(new File("./assets/wordscount.txt").delete());
    }

    @Test
    public void checkCount() {
        Article[] articles = new Article[5];
        articles[0] = new Article("prova uno due tre quattro", "prova due", null);
        articles[1] = new Article("uno due tre quattro", "uno tre quattro", null);
        articles[2] = new Article("uno due tre", "tre", null);
        articles[3] = new Article("uno due", "due", null);
        articles[4] = new Article("uno", "", null);

        Map<String, Integer> manualMap = new HashMap<>();
        manualMap.put("uno", 5);
        manualMap.put("due", 4);
        manualMap.put("tre", 3);
        manualMap.put("quattro", 2);
        manualMap.put("prova", 1);

        WordCounter.getFrequency(articles);

        assertEquals(manualMap, counterFileToMap());

    }

    /**
     * 
     * @return
     */
    private Map<String, Integer> counterFileToMap() {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        Scanner reader;

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


    /**Map<String, Integer> wordFrequencyMap = new HashMap<>();

    public static String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // parole con lunghezza tra 3 e 10
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }*/








}
