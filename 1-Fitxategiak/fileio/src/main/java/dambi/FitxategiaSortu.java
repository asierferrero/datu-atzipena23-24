package dambi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FitxategiaSortu {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Zer zoaz deskribatzera? ");
        String dir = sc.nextLine();

        System.out.print("Zein? ");
        String fitxategiIzena = sc.nextLine();
        
        File fitxategia = new File(dir, fitxategiIzena);
        fitxategia.createNewFile();

        System.out.print("Nolakoa da? ");
        String deskribapena = sc.nextLine();

        FileWriter fileWriter = new FileWriter(fitxategia);
        fileWriter.write(deskribapena);
        fileWriter.close();

        System.out.println("Fitxategia sortuta: " + fitxategia.getAbsolutePath());
    }
}
