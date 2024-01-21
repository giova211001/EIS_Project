# ProjectEIS
Progetto del corso di Elementi di Ingegneria del Software
## Consegna del progetto
Progettare ed implementare un sistema software in grado di
scaricare (download) articoli da testate giornalistiche online resi
disponibili da diverse sorgenti e di estrarre e visualizzare i termini
più “importanti” nell’insieme degli articoli scaricati.
## Come eseguire il progetto
inserire la chiave personale del guardian nel file ./assets/application properties (al posto di test)
Per compilare il progetto e creare il file jar:
```
mvn clean compile assembly:single
```
Per eseguire il l'applicazione tramite il file jar:
```
java -jar .\target\EIS_Project-1.0-SNAPSHOT-jar-with-dependencies.jar -de nuclear+power -A
```

## Cose mancanti da fare
 - Gestire la persistenza dei dati (più sorgenti diverse dovrebbero essere memorizzate in file con formato uguale)
 - Gestire l'input dell'utente tramite CLI
 - Creare classe per estrarre termini e loro peso
 - Capire se per **peso** si intenda:
   - Quante volte appare la parola in tutti gli articoli
   - Oppure in quanti articoli differenti appare quella parola
 
