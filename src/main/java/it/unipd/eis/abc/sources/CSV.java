package it.unipd.eis.abc.sources;

import com.opencsv.CSVReader;
import it.unipd.eis.abc.Article;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe per gestire gli articoli di NYTimes da file CSV presenti in nytimes_articles_v2.csv
 * Ogni file CSV è formato da 4 parametri:
 * - Identifier
 * - Url
 * - Title
 * - Body
 * - Date
 * - Source
 * - Set
 * - Source
 *
 * Implementazione:
 * Prelevo il file dal path e creo un nuovo oggetto Article per salvare tutti gli articoli presenti nel file
 */
public class CSV {

    //percorso del file
    private String path_file;

    //Lista di articoli per poterli salvare
    private ArrayList<Article> articles = new ArrayList<Article>();

    //Costruttore di classe
    public CSV(String path_file)
    {
        this.path_file = path_file;
    }

    //metodo per recuperare gli articoli dal file CSV
    //TODO inserire Article[] al posto di void, l'ho messo solo affinchè non dia errore
    public void getArticles() throws IOException {
        //rappresenta tutti i file presenti nella directory path_file
        File[] files = new File(path_file).listFiles();
        if(files != null && files.length != 0)
        {
            for(File f : files)
            {
                //prelevo il percorso di ogni singolo file nella cartella
                String single_path = f.getAbsolutePath();
                System.out.println("FilePath = " + single_path);
                boolean isFirstLine = true;
                int item = 1;

                try(Scanner scanner = new Scanner(new File(single_path)))
                {
                    while(scanner.hasNextLine())
                    {
                        String line = scanner.nextLine();
                        if(isFirstLine)
                        {
                            isFirstLine = false;
                            continue;
                        }

                        String[] columns = line.split(",");
                        String title = columns[2];
                        String body = columns[3];
                        articles.add(new Article(title, body));
                    }

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
