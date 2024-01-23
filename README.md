# ProjectEIS
Progetto del corso di Elementi di Ingegneria del Software
Componenti del gruppo:
- Giovanni Faedo
- Marco Facco
- Martino Bissiato
- Andrea Maluta

## Consegna del progetto
Progettare ed implementare un sistema software in grado di
scaricare (download) articoli da testate giornalistiche online resi
disponibili da diverse sorgenti e di estrarre e visualizzare i termini
più “importanti” nell’insieme degli articoli scaricati.

### Key TheGuardian
Il programma utilizza una key per comunicare con l'API di The Guardian, ottenibile su https://open-platform.theguardian.com/access.
Una volta scaricato il progetto, è necessario inserire la chiave personale del TheGuardian nel file ./assets/application.properties (al posto di test).
### Come compilare ed eseguire il programma
Per compilare il progetto e creare il file jar:
```
mvn package
```
Per eseguire il l'applicazione tramite il file jar:
```
java -jar .\target\EIS_Project-1.0-jar-with-dependencies.jar -{d, de, e, h} <query> -{C, G, A}
```

Opzioni disponibili:
```
 -d,--download <arg>                 Download the articles
 -de,--download & extraction <arg>   Download and extract
 -e,--extraction                     Extract terms
 -h,--help                           Print the help


 -C                                  CSV file
 -G                                  TheGuardian file
 -A                                  All files
```
Ad esempio, per scaricare ed estrarre (-de) articoli da tutte le fonti disponibili (-A) usando la query nuclear+power:
```
java -jar .\target\EIS_Project-1.0-jar-with-dependencies.jar -de nuclear+power -A
```
### Generazione sito
Per generare il sito, basta eseguire il comando:
```
mvn site
```
