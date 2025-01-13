package ex3;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea șirului principal
        System.out.println("Introduceți șirul principal:");
        String text = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(text);

        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Inserează un șir într-o anumită poziție");
            System.out.println("2. Șterge o porțiune din șir");
            System.out.println("3. Afișează șirul curent");
            System.out.println("4. Ieșire");
            System.out.print("Alegeți o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumă newline

            switch (optiune) {
                case 1:
                    // Inserare șir
                    System.out.print("Introduceți șirul de inserat: ");
                    String sirInserat = scanner.nextLine();
                    System.out.print("Introduceți poziția unde doriți să inserați șirul: ");
                    int pozitieInserare = scanner.nextInt();
                    scanner.nextLine(); // Consumă newline

                    if (pozitieInserare >= 0 && pozitieInserare <= stringBuilder.length()) {
                        stringBuilder.insert(pozitieInserare, sirInserat);
                        System.out.println("Șirul după inserare: " + stringBuilder);
                    } else {
                        System.out.println("Poziția introdusă este invalidă!");
                    }
                    break;

                case 2:
                    // Ștergere porțiune
                    System.out.print("Introduceți poziția de început a ștergerii: ");
                    int start = scanner.nextInt();
                    System.out.print("Introduceți numărul de caractere de șters: ");
                    int numarCaractere = scanner.nextInt();
                    scanner.nextLine(); // Consumă newline

                    int end = start + numarCaractere;
                    if (start >= 0 && end <= stringBuilder.length() && start < end) {
                        stringBuilder.delete(start, end);
                        System.out.println("Șirul după ștergere: " + stringBuilder);
                    } else {
                        System.out.println("Intervalul introdus este invalid!");
                    }
                    break;

                case 3:
                    // Afișare șir curent
                    System.out.println("Șirul curent este: " + stringBuilder);
                    break;

                case 4:
                    // Ieșire
                    System.out.println("Program încheiat.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opțiune invalidă! Reîncercați.");
                    break;
            }
        }
    }
}

