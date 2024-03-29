package it.unipd.eis.dei;

/**
 * Struttura di un articolo di giornale online con le informazioni essenziali:
 * - Titolo articolo (title)
 * - Corpo articolo (body)
 * - Sorgente di provenienza (CSV o TheGuardian)
 */
public class Article {

    private String title;
    private String body;
    private String source;

    //costruttore senza parametri della classe
    public Article() { }

    //costruttore con parametri della classe
    public Article(String title, String body, String source){

        this.title = title;
        this.body = body;
        this.source = source;
    }

    public Article(String title, String body)
    {
        this.title = title;
        this.body = body;
    }

    public String getTitle()
    {
        return title;
    }

    public String getBody()
    {
        return body;
    }

    public String getSource()
    {
        return source;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString()
    {
        String s = "Article [" + source + "]\n" +
                "Title: " + getTitle() + "\n" +
                "Body: " + getBody();

        return s;
    }
}
