import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private Path pathDomande;
    private Path pathRisposte;
    private Path pathRispostaCorretta;
    public List<String> domande = new ArrayList<>();
    public List<String> risposte = new ArrayList<>();
    public List<String> rispstaCorretta = new ArrayList<>();

    public Quiz(int tipo) { 
        try{
            if(tipo == 1){// Quiz tema videogame
               pathDomande = Paths.get("./src/Domande_Videogame.txt");
               pathRisposte = Paths.get("./src/Risposte_Videogame.txt");
               pathRispostaCorretta = Paths.get("./src/Risposta_Corretta_Videogame.txt");
               domande = Files.readAllLines(pathDomande);
               risposte = Files.readAllLines(pathRisposte);
               rispstaCorretta = Files.readAllLines(pathRispostaCorretta);

            }
            else {// Quiz tema anime
                pathDomande = Paths.get("./src/Domande_Anime.txt");
                pathRisposte = Paths.get("./src/Risposte_Anime.txt");
                pathRispostaCorretta = Paths.get("./src/Risposta_Corretta_Anime.txt");
                domande = Files.readAllLines(pathDomande);
                risposte = Files.readAllLines(pathRisposte);
                rispstaCorretta = Files.readAllLines(pathRispostaCorretta);
            }
        }catch (IOException e){
            System.out.println(("Errore durante la lettura dei file"));
            System.out.println(e);
        }
    }
}