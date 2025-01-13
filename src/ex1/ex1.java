package ex1;
import java.io.*;
import java.util.*;

public class ex1 {
    public static void main(String[] args) {
        // Numele fișierului care conține lista de județe
        String fileName = "judete_in.txt";

        try {
            // Citirea datelor din fișier într-o listă
            List<String> judeteList = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    judeteList.add(line.trim());
                }
            }

            // Convertirea listei într-un tablou
            String[] judeteArray = judeteList.toArray(new String[0]);

            // Sortarea tabloului de județe
            Arrays.sort(judeteArray);
            System.out.println("Județele ordonate: " + Arrays.toString(judeteArray));

            // Citirea unui județ de la tastatură
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți județul căutat: ");
            String judetCautat = scanner.nextLine().trim();

            // Căutarea binară a județului în tabloul sortat
            int pozitie = Arrays.binarySearch(judeteArray, judetCautat);

            if (pozitie >= 0) {
                System.out.println("Județul \"" + judetCautat + "\" se află pe poziția: " + pozitie);
            } else {
                System.out.println("Județul \"" + judetCautat + "\" nu a fost găsit în listă.");
            }

        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("A apărut o eroare: " + e.getMessage());
        }
    }
}
