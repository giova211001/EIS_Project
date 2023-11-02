package it.unipd.eis.abc;

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
        CommandLine cmd;
        HelpFormatter formatter = new HelpFormatter();

        try
        {
             cmd = parser.parse(opt, args);

        }catch (ParseException e) {
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
        else if(cmd.hasOption("d"))
        {
            System.out.print("Sto scaricando (d) la query che mi è stata fatta =  "+cmd.getOptionValue("d"));
        }
        else if(cmd.hasOption("de"))
        {
            System.out.print("Sto scaricando (d) in base alla query:" + cmd.getOptionValue("de") + " e sto estrando ");
        }
        else if (cmd.hasOption("e"))
        {
            System.out.println("Sto estrando da una specie di database che contiene tutti i file da ogni sorgente");
        }

        //possibili opzioni
        //opt.addOption(new Option("cw", true, "Count words"));
        //opt.addOption(new Option("ca", "nlp-pipeline", true, "CoreNLP"));



    }
}
