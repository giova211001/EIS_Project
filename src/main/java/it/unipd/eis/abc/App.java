package it.unipd.eis.abc;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

/**
 * Classe per eseguire il programma e gestire l'interazione dell'utente con la CLI (Command Line Interface)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Options opt = new Options();
        //importo tutte le possibili azioni in una actionGroup
        OptionGroup action = new OptionGroup();
        action.addOption(new Option("h", "help", false, "Print the help"));
        action.addOption(new Option("e", "extraction", true, "Extract terms"));

        action.setRequired(true);
        opt.addOptionGroup(action);

        //possibili opzioni
        opt.addOption(new Option("pf", true, "Property file path"));
        opt.addOption(new Option("np", "nlp-pipeline", true, "CoreNLP"));



    }
}
