package it.unipd.eis.dei;

import it.unipd.eis.dei.sources.TheGuardian;
import it.unipd.eis.dei.tools.Downloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di Test per TheGuardian - controllo che l'ottenimento degli articoli del TheGuardian avvenga in modo corretto
 */
public class TheGuardianTest {

    private TheGuardian testGuardian;
    private static final String QUERY = "nuclear+power";

    @BeforeEach
    public void setUp() {
        testGuardian = new TheGuardian(QUERY);
    }

    @Test
    public void getArticleTest() {

        // Controllo che getArticles() non restituisca null
        Article[] articles = testGuardian.getArticles();
        Downloader.downloadGuardian(QUERY);
        assertNotNull(articles);

        // Controllo che l'array di articoli non sia vuoto dopo avere chiamato il metodo getArticles()
        assertTrue(articles.length > 0);

        // Controllo della sorgente
        assertEquals("TheGuardian", articles[1].getSource());
        assertNotNull(articles[5].getSource());

        // Controllo del body
        assertTrue(articles[2].getBody().toLowerCase().contains("power"));
        assertNotNull(articles[4].getBody());

        // Controllo titoli
        assertTrue(articles[6].getTitle().toLowerCase().contains("power"));
        assertNotNull(articles[8].getTitle());

    }

}
