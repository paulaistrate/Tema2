package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ex2 {
    public static void main(String[] args) {
        String inputFile = "cantec_in.txt";
        String outputFile = "cantec_out.txt";
        String grupLitere = "re"; // Grup de litere ales pentru marcarea cu steluță
        double probabilitateMajuscule = 0.1;

        List<Vers> versuri = new ArrayList<>();

        // Citirea versurilor din fișier
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                versuri.add(new Vers(linie));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
            return;
        }

        // Scrierea versurilor procesate în fișierul de ieșire
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            Random random = new Random();

            for (Vers vers : versuri) {
                int numarCuvinte = vers.getNumarCuvinte();
                int numarVocale = vers.getNumarVocale();
                String continut = vers.getContinut();

                // Verificarea probabilității pentru majuscule
                if (random.nextDouble() < probabilitateMajuscule) {
                    continut = vers.inMajuscule();
                }

                // Adăugarea steluței dacă versul se termină cu grupul de litere specificat
                if (vers.seTerminaCu(grupLitere)) {
                    continut += " *";
                }

                // Scrierea versului în fișier
                bw.write(continut + " [Cuvinte: " + numarCuvinte + ", Vocale: " + numarVocale + "]");
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Eroare la scrierea fișierului: " + e.getMessage());
        }

        System.out.println("Procesarea s-a terminat cu succes. Verificați fișierul " + outputFile);
    }
}
