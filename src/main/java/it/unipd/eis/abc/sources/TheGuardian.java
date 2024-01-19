package it.unipd.eis.abc.sources;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import it.unipd.eis.abc.Article;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe per la gestione degli articoli provenienti dal The Guardian
 * La classe deve fare le seguenti operazioni:
 * 1) Fare una richiesta all'API TheGuardian
 * 2) Ricevere la risposta (in formato JSON)
 * 3) Fare il parsing della risposta JSON (body)
 */
public class TheGuardian implements SourceInterface{

    //impostazione dell'URL del The Guardian
    private static String GUARDIAN_URL = "http://content.guardianapis.com/search";

    //array di oggetti della classe Article
    public ArrayList<Article> articles = new ArrayList<>();

    //chiave privata per accedere alle API
    //la chiave va modificata con la chiave ottenuta dal sito The Guardian
    private String api_key = "test";
    //una query con più di una parola viene concatenata con +
    private String query;
    //per reperire il corpo dell'articolo
    private String show_fields = "bodyText";

    //Costruttore della classe
    public TheGuardian(String query)
    {
        this.query = query;
    }

    public String createUrl(String q)
    {
        return GUARDIAN_URL+"?q=" + q + "&api-key=" + api_key + "&show-fields=" + show_fields;
    }

    /**
     * Metodo per effettuare la richiesta alle API di TheGuardian, ottenere la risposta e salvare gli
     * Articoli in un ArrayList
     * @return Array di Articoli salvati in formato Article
     */
    public Article[] getArticles() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(createUrl("nuclear+power"));

        try {
            //lancia eccezione IOException
            HttpResponse httpResponse = httpClient.execute(httpGet);
            String response = readableFormat(EntityUtils.toString(httpResponse.getEntity()));

            //leggo all'interno del JSON tramite ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            JsonNode result = root.get("response").get("results");


            for(JsonNode n: result)
            {
                String title = n.get("webTitle").asText();
                String body = n.get("fields").get("bodyText").asText();
                articles.add(new Article(title, body, "TheGuardian"));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return articles.toArray(new Article[0]);

    }

    /**
     * Metodo per formattare la stringa JSON in modo che sia più facilmente leggibile
     * tramite la funzione setPrettyPrinting() della classe Gson
     * @param response, risposta dal TheGuardian da formattare
     * @return risposta in un formato più leggibile
     */
    public String readableFormat(String response)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement element = gson.fromJson(response, JsonElement.class);
        String formatted_response = gson.toJson(element);
        return formatted_response;
    }



}
