package dambi;

import java.util.Scanner;
import java.io.*;

public class MainMenua {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENDIEN MENUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    ikusi();
                    break;
                case 2:
                    altuena();
                    break;
                case 3:
                    esportatu();
                    break;
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 4);
        in.next();
        in.close();
    }

    public static void ikusi() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Mendiak.csv"));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] fields = line.split(";");

            if (fields.length >= 3) {
                String field1 = fields[0];
                String field2 = fields[1];
                String field3 = fields[2];

                System.out.printf("%-12s | %-12s | %-12s %n", field1, field2, field3);
            }
        }
        sc.close();
    }

    public static void altuena() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Mendiak.csv"));
        int altuena = 0;
        String izena = "";

        if (sc.hasNextLine()) {
            sc.nextLine(); // Lehenengo lerroa ez irakurtzeko
        }
        while (sc.hasNextLine()) {
            String lerroa = sc.nextLine(); // Lerro bakoitza lerroa-n gorde
            String[] fields = lerroa.split(";"); // ;-ra arte

            if (fields.length >= 2) {
                int altuera = Integer.parseInt(fields[1]); // Altuera bigarren field-ean dagoelako
                if (altuera > altuena) {
                    izena = fields[0];
                    altuena = altuera;
                }
            }
        }
        sc.close();
        System.out.println("Mendi altuena " + izena + " da eta " + altuena + " metroko altuera du.");
    }

    public static void esportatu() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Mendiak.csv"));
        // BufferedReader inputStream = null;

        // inputStream = new BufferedReader(new FileReader("Mendiak.csv"));

        PrintWriter gipuzkoa = new PrintWriter(new File("Gipuzkoa.csv"));
        PrintWriter bizkaia = new PrintWriter(new File("Bizkaia.csv"));
        PrintWriter araba = new PrintWriter(new File("Araba.csv"));
        PrintWriter nafarroa = new PrintWriter(new File("Nafarroa.csv"));

        // String line;
        // while ((line = inputStream.readLine()) != null) {
        while (sc.hasNextLine()) {
            String lerroa = sc.nextLine(); // Lerro bakoitza lerroa-n gorde
            String[] fields = lerroa.split(";"); // ;-ra arte

            switch (fields[2]) {
                case "Gipuzkoa":
                    gipuzkoa.println(lerroa);
                    break;
                case "Bizkaia":
                    bizkaia.println(lerroa);
                    break;
                case "Araba":
                    araba.println(lerroa);
                    break;
                case "Nafarroa":
                    nafarroa.println(lerroa);
                    break;
                default:
                    break;
            }
        }
        gipuzkoa.close();
        bizkaia.close();
        araba.close();
        nafarroa.close();

        sc.close();
    }
}
