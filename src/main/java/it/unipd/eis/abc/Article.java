package it.unipd.eis.abc;

/**
 * Struttura di un articolo di giornale online con teso e body
 */
public class Article {

    private String title;
    private String body;

    //costruttore della classe
    public Article() { }

    //costruttore con parametri della classe
    public Article(String title, String body){

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

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        String s = "Article Details + \n" +
                "Title: " + getTitle() + "\n" +
                "Body: " + getBody();

        return s;
    }
}
