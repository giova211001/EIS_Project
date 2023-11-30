package it.unipd.eis.abc;

import it.unipd.eis.abc.tools.Downloader;
import it.unipd.eis.abc.tools.WordCounter;
import org.apache.commons.cli.*;

/**
 * Classe per eseguire il programma e gestire l'interazione dell'utente con la CLI (Command Line Interface)
 *
 */
public class App
{
    public static void main( String[] args )
    {
        CommandLineParser parser = new DefaultParser();
        Options opt = new Options();
        //importo tutte le possibili azioni in una actionGroup
        OptionGroup action = new OptionGroup();
        action.addOption(new Option("d", "download", true, "Download the articles"));
        action.addOption(new Option("de", "download & extraction", true, "Download and extract"));
        action.addOption(new Option("e", "extraction", false, "Extract terms"));
        action.addOption(new Option("h", "help", false, "Print the help"));

        action.setRequired(true);
        opt.addOptionGroup(action);

        //importo tutte le possibili [options] per download
        opt.addOption(new Option("C", false, "CSV file"));
        opt.addOption(new Option("G", false, "TheGuardian file"));
        opt.addOption(new Option("A", false, "All files"));
        CommandLine cmd;
        HelpFormatter formatter = new HelpFormatter();

        try
        {
             cmd = parser.parse(opt, args);

        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("ERROR - Parsing errato");
            System.err.println(e.getMessage());
            formatter.printHelp("App -{d,de,e,h} [options]", opt);
            return;

        }
        if(cmd.hasOption("h"))
        {
            formatter.printHelp("App -{d,de,e,h} [options]", opt);
        }
        //OPZIONE: download
        if(cmd.hasOption("d") || cmd.hasOption("de"))
        {

            String query = cmd.hasOption("d") ? cmd.getOptionValue("d"): cmd.getOptionValue("de");

            // Scelta sorgenti da scaricare
            // CLI fatta nel seguente modo -d nuclear+power -{C, G, A}

            if(cmd.hasOption("C")) // solo dal file CSV
            {
                System.out.println("Scaricamento dal file CSV...");
                Downloader.downloadCSV();

            }
            else if(cmd.hasOption("G")) // solo dalle API del TheGuardian
            {
                System.out.println("Scaricamento dalle API del TheGuardian...");
                Downloader.downloadGuardian(query);
            }
            else if(cmd.hasOption("A")) //da entrambi
            {
                System.out.println("Scaricamento dal file CSV file e dalle API del TheGuardian...");
                Downloader.downloadAll(query);
            }

            System.out.println("Ho scaricato gli articoli con la query = " + query);
        }
        if (cmd.hasOption("e") || cmd.hasOption("de"))
        {
            System.out.println("Estrazione dei termini più frequenti dagli articoli scaricati ...");
            WordCounter.getFrequency();
            System.out.println("Estrazione completata!");
        }

        // possibili opzioni
        // opt.addOption(new Option("cw", true, "Count words"));
        // opt.addOption(new Option("ca", "nlp-pipeline", true, "CoreNLP"));



    }
}
