package it.unipd.eis.dei;

import it.unipd.eis.dei.sources.CSV;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Classe per il test della lettura dal file di tipo CSV
 */

public class CSVTest {

    //oggetto di tipo CSV
    private CSV testCsv;

    private final String TEST_CSV_PATH = "./assets/csv/";

    //imposto la configurazione inziale
    @BeforeEach
    public void initialSetUp()
    {
        testCsv = new CSV(TEST_CSV_PATH);
    }

    /**
    * Metodo che controlla la che la ricezione degli articoli avvenga correttamente. Viene testato quindi il
    * metodo getArticles()
    * Viene controllato che:
     * - chiamando il metodo non si ottenga un array nullo
     * - il numero di elementi sia 1000 (totale degli articoli)
     * - il titolo e il corpo del primo articolo sia corretto
     * - il titolo e il corpo di un articolo casuale sia corretto
     * - la sorgente del primo articolo e di un articolo casuale sia CSV
     **/

    @Test
    public void getArticlesTest()
    {
        //verifico che chiamando il metodo getArticles() non ottengo un array nullo
        Article[] articles = testCsv.getArticles();
        //controllo che non sia nullo
        assertNotNull(articles);
        //controllo che vi siano il numero di elementi che ci aspettiamo, ovvero 1000
        assertEquals(1000, articles.length);

        // --------TITOLO------------------------
        //Verifico il titolo del primo articolo
        Article a1 = testCsv.getArticles()[0];
        //Controllo che il titolo sia quello che ci aspettiamo
        assertEquals("Hard Questions on Nuclear Power", a1.getTitle());
        //Controllo che un titolo preso randomicamente tra 0 e 999 non sia nullo
        Random rand = new Random();
        int randomTitle = rand.nextInt(1000);
        //prelevo articolo con il seguente titolo e controllo che non sia null
        Article randomT = testCsv.getArticles()[randomTitle];
        assertNotNull(randomT.getTitle());

        // ---------BODY----------------
        // Verifico il corpo del primo articolo
        String body1 = "After decades in the doghouse because of environmental, safety and cost concerns, nuclear power is enjoying a renaissance of expectations. The Bush administration's new energy plan gives a place of prominence to nuclear power as a clean and efficient energy source, and the industry itself is bubbling with new hopes and plans. In truth, there are good reasons to take a fresh look at this much-maligned source of energy that has been stalled in this country for the past three decades. But it is worrisome that the administration seems to have endorsed a nuclear resurgence with little sustained analysis of its pluses and minuses. As an article by Katharine Seelye in The Times revealed last week, nuclear energy was barely in the consciousness of the drill-centric energy team at the White House until a delegation of nuclear industry executives sought a chance to make their pitch and succeeded so well that Vice President Dick Cheney almost immediately started touting the virtues of nuclear energy. A case can be made for greater exploitation of nuclear power in this country, but before the nation plunges too far down this path the administration will need to address some critical questions. The rationale for a reassessment comes partly from the performance of the industry itself, and partly from changed circumstances in the environment in which it must operate. By most accounts, the industry has learned to operate its plants more safely and efficiently than in the years leading up to the traumatic near-tragedy at Three Mile Island. American nuclear plants are operating with much greater reliability and many fewer minor incidents. Moreover, the industry is consolidating, with plants being purchased and operated by companies that have more expertise than some of the previous operators. So there is reason to trust the industry a bit more than in past decades. Meanwhile, external events are increasing the appeal of nuclear power. One is the rising concern over global warming, which is caused primarily by the emission of carbon dioxide from burning fossil fuels. Nuclear power plants emit no carbon dioxide, thus to the extent they can replace plants burning coal, oil or natural gas they can be considered a plus. Nuclear power can also contribute to the diversity of the nation's energy supplies. Nuclear plants already supply some 20 percent of the electricity generated in this country, compared with fossil fuel contributions of 52 percent for coal, 16 percent for natural gas and 3 percent for oil. But the great majority of all new power plants are being built to burn natural gas, the cleanest of the fossil fuels, making utilities and consumers vulnerable to price spikes when supplies become tight as they have this year. President Bush's energy plan offers a wide range of steps to accelerate the use of nuclear power. But before Congress and the regulatory agencies proceed too far, some crucial questions require answers. Impact on global warming: If this is the main reason for turning to nuclear power, the proponents will need to do a much better job of spelling out just how far nuclear power would have to spread to make a real dent in the problem. Nuclear power is used almost exclusively to generate electricity, thus it cannot reduce the nation's reliance on imported oil to power transportation systems. Nuclear fuel will primarily be substituting for natural gas -- the least of the carbon dioxide emitters -- as the clean fuel to which electric utilities turn. Moreover, fossil fuels are burned in mining and preparing nuclear fuels and in building reactors, so even nuclear energy is not entirely free of greenhouse gases. Some analyses suggest that to make a real impact in slowing global warming, nuclear power plants would need to spread widely around the world, a prospect that brings new challenges of its own. Weapons risks: Expansion of nuclear power in this country poses no weapons danger, but the spread of nuclear plants into other countries could pose a risk. The uranium fuel for nuclear power plants is not generally considered of high enough grade to be used in weapons. But as more and more technicians around the world learn the skills of working with nuclear materials, and as governments become engaged in procuring nuclear technologies, there is a danger that civilian nuclear programs could serve as a cover for clandestine weapons activities. That is why, for example, the United States is angry that Russia is helping Iran build a nuclear power plant. Even though Iran has pledged to abide by nonproliferation treaties and allow international inspections of the plant, there is grave concern that it will find a way to build weapons. Increasing the use of nuclear power in countries that already have either the bomb or nuclear power plants is not much of a danger. Spreading nuclear power to additional countries might be. Waste disposal: In the political world, the lack of a proven method to store spent fuel from nuclear reactors for the tens of thousands of years the material remains radioactive has long been considered the Achilles' heel of the nuclear industry. In truth, spent fuel has been stored safely for decades in pools at the sites of nuclear power plants with no adverse effect. The problem is, the storage pools are filling up and critics are loath to expand nuclear power with no clear idea where to store the waste. The Bush administration is considering a site at Yucca Mountain in Nevada that has been studied for years, and it has proposed a new look at reprocessing the fuel to remove the long-lived plutonium for reuse as reactor fuel. That could greatly ease the storage problem here but might encourage wider use of reprocessed materials abroad, increasing the risk of weapons-grade plutonium's falling into the wrong hands. Reactor safety: The safety problem in conventional nuclear plants is that, if things start to go wrong, emergency cooling systems and human operators have to act correctly to prevent a catastrophic meltdown. That makes nuclear power a cruel and unforgiving technology that cannot tolerate equipment failures or human mistakes. But the industry is exploring new technologies that would not lead to meltdown even in a worst-case malfunction, making them inherently safer and cheaper to build and operate. This is where the administration and the industry should be focusing their efforts -- to develop demonstrably safer power plants. That would ease many of the concerns provoked by the current generation of nuclear reactors. Economics: No matter what else is done to make nuclear power more attractive, the industry will make little headway unless it can overcome the high capital costs that brought it to a halt in recent decades. Some relief should come from the advance approval of standardized designs, allowing plants to be built more quickly and cheaply than in past years when each plant had a customized design. But Congress will need to take a close look at whether it should renew one of the industry's economic underpinnings -- the so-called Price-Anderson Act that limits the liability of nuclear companies in the event of an accident. If the industry is as safe as it says, it may not need such subsidized protection. On the other hand, eliminating the liability protection might scare off investors for good. Nuclear power has been stalled for so long in the United States that it is surprising to see it back in the spotlight. There may be a case for extending the licenses of existing plants, as has already happened in several cases, or for building new plants on existing nuclear sites where the risks are already understood. But the case has not yet been made for truly large-scale expansion of nuclear power, in this country or around the globe.";
        //Controllo che un corpo preso random non sia nullo
        int randomBody = rand.nextInt(1000);
        Article randomB = testCsv.getArticles()[randomBody];
        assertNotNull(randomB.getBody());

        // ---------SOURCE--------------
        // Verifico che la sorgente sia CSV
        assertEquals("CSV", a1.getSource());
        // Verifico che un altro articolo random abbia la stessa sorgente
        int randomSource = rand.nextInt(1000);
        Article randomS = testCsv.getArticles()[randomSource];
        assertEquals("CSV", randomS.getSource());
    }

    /**
     * Metodo per verificare il caso in cui non venga trovato il percorso del file oppure
     * venga trovato un percorso invalido
     * Il metodo dovrebbe verificare che la lista di articles sia vuota perchè non ha
     * trovato la sorgente
     */
    @Test
    public void getArticlesWithoutSources()
    {
        //Inserisco un percorso invalido così da non trovare il file
        CSV invalid = new CSV("no_path_file");
        Article[] articles = invalid.getArticles();
        //Verifico che l'array di articoli sia vuoto perchè non ha trovato la sorgente
        assertEquals(0, articles.length);
        //Verifico che l'array non sia nullo
        assertNotNull(articles);
    }
}
