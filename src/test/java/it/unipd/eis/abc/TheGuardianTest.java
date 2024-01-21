package it.unipd.eis.abc;

import it.unipd.eis.abc.analyze.Serializer;
import it.unipd.eis.abc.sources.TheGuardian;
import it.unipd.eis.abc.tools.Downloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di Test per TheGuardian - controllo che l'ottenimento degli articoli del TheGuardian avvenga in modo corretto
 */
public class TheGuardianTest {

    private TheGuardian testGuardian;
    private static final String QUERY = "nuclear+power";

    @BeforeEach
    public void setUp() {
        testGuardian = new TheGuardian(QUERY);
    }

    @Test
    public void getArticleTest() {

        // Controllo che getArticles() non restituisca null
        Article[] articles = testGuardian.getArticles();
        Downloader.downloadGuardian(QUERY);
        assertNotNull(articles);

        // Controllo che l'array di articoli non sia vuoto dopo avere chiamato il metodo getArticles()
        assertTrue(articles.length > 0);

        // Controllo della sorgente
        assertEquals("TheGuardian", articles[1].getSource());
        assertNotNull(articles[5].getSource());

        // Controllo del body
        assertTrue(articles[2].getBody().toLowerCase().contains("power"));
        assertNotNull(articles[4].getBody());

        // Controllo titoli
        assertTrue(articles[6].getTitle().toLowerCase().contains("power"));
        assertNotNull(articles[8].getTitle());

        // Verifica il contenuto del primo articolo
        assertEquals("UAE approached to invest in Sizewell C nuclear power plant", articles[0].getTitle());
        assertEquals("A United Arab Emirates investor has been approached to take a stake in the Sizewell C nuclear power plant project in Suffolk, it has emerged. Ministers are searching for new investors in the project, which could cost between £20bn and £44bn, after removing the Chinese state-owned CGN last year due to security concerns over UK infrastructure amid poor Anglo-Sino relations. The Times reported on Monday that the UK government had lined up Mubadala, the Abu Dhabi fund run by Sheikh Mansour bin Zayed Al Nahyan, the owner of Manchester City football club, to back the energy project, with a decision due early next year. However, a source close to Mubadala denied the fund was interested in Sizewell but said other UAE entities were interested. A separate source said that Emirates Nuclear Energy Corporation, which is owned by Abu Dhabi sovereign wealth fund ADQ, could be a good fit for the project. The UAE interest comes against the backdrop of Westminster tensions over a separate Emirati deal. Last week, RedBird IMI – a joint-venture between America’s Redbird Capital and International Media Investments, an Abu Dhabi investor also backed by Mansour – announced a deal to take control of the Telegraph group. The government has indicated it will launch a public interest investigation into the newspaper deal. The Sizewell C plant aims to generate enough energy to power 6m homes. It is backed by France’s EDF and the UK government, which has spent nearly £100m buying CGN out of the project. CGN had held a 20% stake. Rishi Sunak hosted Mubadala’s Khaldoon Al Mubarak at a meeting of global business leaders at Hampton Court, south-west London, on Monday as he attempts to attract foreign investment to the UK. Although a formal search for outside investment launched in September, Sizewell C has been touted to potential investors – including sovereign wealth funds, infrastructure and pension funds – for years. The government earmarked a further £341m to develop the project in August. Bankers at Barclays have been tasked with procuring investment for the project, which has faced significant opposition in Suffolk. The interest from the UAE – host of Cop28, which begins this week – in Sizewell C has been mooted for more than a year. Last week, campaigners parked a sign reading “Sizewell C is a toxic investment” outside the UAE embassy in London. Alison Downes, of the Stop Sizewell C campaign, said: “There may be a dearth of UK interest in Sizewell C, but there is no energy security in handing chunks of the UK’s critical national assets to countries that don’t share our values. If the UAE is not good enough for the Telegraph, it’s definitely not good enough for Sizewell C.” Investors in Saudi Arabia and Australia have also previously reportedly been approached to back Sizewell C. However, a source close to the project denied there was active interest from Saudi investors. Last year, the Observer revealed that the British Gas owner Centrica – a minority investor in Britain’s nuclear power stations – was interested. Greencoat Capital, the investment firm, has also expressed an interest. The project is set up as a 50-50 joint-venture between the government and EDF, which is behind the sister Hinkley Point C development in Somerset. That project is significantly over budget and years late. Ministers overruled the independent Planning Inspectorate to grant Sizewell C planning consent. Backers are seeking a development consent order that will precede a final investment decision by its backers. The plant is not expected to generate power until at least the mid-2030s, after most of Britain’s nuclear power stations have been retired. Sunak’s government hopes to kickstart a renaissance in the nuclear power industry, and launched a new delivery body, Great British Energy, in the summer. Separately, the boss of Rolls-Royce, Tufan Erginbilgic, is expected to urge the government to back its plans to build small nuclear power plants at an investor day on Tuesday. Sizewell C and Mubadala have been approached for comment.", articles[0].getBody());



    }

}
