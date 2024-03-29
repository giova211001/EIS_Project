package it.unipd.eis.dei.sources;

import it.unipd.eis.dei.Article;

/**
 * Interfaccia per supportare diversi tipi di sorgente.
 * Ogni sorgente deve avere un metodo per ottenere gli articoli, ovvero getArticles()
 */

public interface SourceInterface {

    /**
     * Metodo per ottenere gli articoli da una determinata sorgente
     * @return Array di oggetto di tipo Article
     */
    Article[] getArticles();
}
