import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Partecipante> partecipanti = new ArrayList<>();
        Scanner mainsc = new Scanner(System.in);
        int l = 1; //per risoluzione secondo bug
        int numeroPartecipanti = 1;
        int contatore = 1;
        int domandeTotali = 50;
        int selezionePartecipante = 0;
        int vincitore = -1;
        String risposta = "";
        int selezioneDomanda;
        int maxDomande;
        boolean rispostaValida = false;

        System.out.println("inserisci numero partecipanti:");
        numeroPartecipanti = mainsc.nextInt();

        while (contatore <= numeroPartecipanti){
            if(contatore == 1) {
                String k = mainsc.nextLine();//per risolvere un bug
            }
            System.out.println("inserisci nome partecipante " + contatore + ":");
            Partecipante partecipante = new Partecipante(mainsc.nextLine());
            partecipanti.add(partecipante);
            contatore++;
        }

        contatore = 1;
        System.out.println();
        System.out.println("inserisci il tema del quiz:\n" +
                "Videogame(1) Anime(2)");
        Quiz quiz = new Quiz(mainsc.nextInt());

        System.out.println("inserisci quante domande ci saranno\n" +
                "minimo 5, massimo 50");
        maxDomande = mainsc.nextInt();
        if(maxDomande<5 || maxDomande > 50){
            maxDomande = 5;
        }

        System.out.println("Bene ora possiamo iniziare\n" +
                "(per rispondere inserire il numero della risposta)");

        while (contatore <= maxDomande){
            selezioneDomanda = (int)(Math.random() * domandeTotali);
            System.out.println();
            System.out.println(quiz.domande.get(selezioneDomanda));
            System.out.println(quiz.risposte.get(selezioneDomanda));
            for (Partecipante parteicpante:partecipanti){
                rispostaValida = false;
                while (rispostaValida == false) {
                    System.out.println(partecipanti.get(selezionePartecipante).getNome() + " inserisci la tua risposta:");
                    if(l == 1) {
                        String k = mainsc.nextLine();//risoluzione bug
                        l++;
                    }
                    risposta = mainsc.nextLine();
                    if (risposta.equals("1") || risposta.equals("2") || risposta.equals("3") || risposta.equals("4")){
                        rispostaValida = true;
                    }
                    else{
                        System.out.println("risposta non valida");
                    }
                }
                if (risposta.equals(quiz.rispstaCorretta.get(selezioneDomanda))){
                    partecipanti.get(selezionePartecipante).addpunti();
                }
                selezionePartecipante++;
            }
            System.out.println();
            System.out.println("La risposta corretta era la " + quiz.rispstaCorretta.get(selezioneDomanda));
            System.out.println();
            for (Partecipante partecipante:partecipanti){
                System.out.println(partecipante);
            }
            contatore++;
            domandeTotali--;
            selezionePartecipante = 0;
            quiz.domande.remove(selezioneDomanda);
            quiz.risposte.remove(selezioneDomanda);
            quiz.rispstaCorretta.remove(selezioneDomanda);
        }
    }
}
