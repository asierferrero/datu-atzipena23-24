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
            System.out.println("4.- ...");
            System.out.println("5.- Irten");
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
                case 5:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 5);
        in.next();
    }

    public static void ikusi() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Mendiak.csv"));

        while (sc.hasNextLine()) {
            String l = sc.nextLine();
            String a = l.replaceAll(";", " | ");
            System.out.printf(a);
            System.out.println();
        }

        sc.close();
    }

    public static void altuena() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Mendiak.csv"));
        int lehenAltuera, altueraBerria;

        while (sc.hasNext()) {
            String l;
            if (altueraBerria > lehenAltuera) {
                l.append(altueraBerria);

            } else {
                sc.nextLine();
            }

        }

        sc.close();
    }
}
