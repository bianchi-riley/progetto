import java.util.ArrayList;
import java.util.List;

public class Partecipante {
    private String nome;
    private int punteggio;

    public Partecipante(String nome) {
        this.nome = nome;
        punteggio = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void addpunti(){
        punteggio += 1;
    }

    @Override
    public String toString() {
        return nome + ':' + punteggio + "punti";
    }
}
