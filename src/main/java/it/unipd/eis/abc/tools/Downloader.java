package it.unipd.eis.abc.tools;

import it.unipd.eis.abc.Article;
import it.unipd.eis.abc.analyze.Serializer;
import it.unipd.eis.abc.sources.CSV;
import it.unipd.eis.abc.sources.TheGuardian;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Classe per scaricare gli articoli da diverse fonti e salvarle in formato JSON,
 * per poter essere successivamente elaborati.
 */
public class Downloader {
    /**
     * Salva gli articoli ottenuti tramite le api del the guardian in formato JSON
     * nel file "assets/articles.json"
     * @param query sezione di testo che gli articoli devono contenere per essere
     *              salvati nel file
     */
    public static void downloadGuardian(String query) {
        TheGuardian guardian = new TheGuardian(query);
        Serializer.Article_to_JSON(guardian.getArticles());
    }

    /**
     * Salva gli articoli del NY times in formato csv nel file "assets/articles.json"
     */
    public static void downloadCSV() {
        CSV csv = new CSV("./assets/csv");
        Serializer.Article_to_JSON(csv.getArticles());
    }

    /**
     * Salva gli articoli ottenuti nel file "assets/articles.json"
     * @param query sezione di testo che gli articoli devono contenere per essere
     *              salvati nel file
     */
    public static void downloadAll(String query) {
        TheGuardian guardian = new TheGuardian(query);
        CSV csv = new CSV("./assets/csv");
        Article[] db = ArrayUtils.addAll(guardian.getArticles(), csv.getArticles());
        Serializer.Article_to_JSON(db);
    }

}
