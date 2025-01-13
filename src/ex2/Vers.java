package ex2;
import java.util.Arrays;

public class Vers {
    private String continut;

    public Vers(String continut) {
        this.continut = continut;
    }

    // Metodă care calculează numărul de cuvinte din vers
    public int getNumarCuvinte() {
        return continut.trim().isEmpty() ? 0 : continut.trim().split("\\s+").length;
    }

    // Metodă care calculează numărul de vocale din vers
    public int getNumarVocale() {
        return (int) continut.toLowerCase().chars()
                .filter(c -> "aeiouăâî".indexOf(c) != -1)
                .count();
    }

    // Metodă care verifică dacă versul se termină cu un grup de litere specificat
    public boolean seTerminaCu(String grupLitere) {
        return continut.trim().endsWith(grupLitere);
    }

    // Metodă care returnează continutul versului
    public String getContinut() {
        return continut;
    }

    // Metodă care convertește versul în majuscule
    public String inMajuscule() {
        return continut.toUpperCase();
    }
}
