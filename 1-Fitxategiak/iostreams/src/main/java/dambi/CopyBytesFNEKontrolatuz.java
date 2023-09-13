package dambi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte
 * irakurtzen du,
 * byte bakoitza outagain.txt fitxategian idatziz. Horrez gain, fitxategia
 * aurkitzen ez badu mezu bat aterako du.
 */

public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        String correctFile = "xanadu";
        String txt = ".txt";

        try {
            in = new FileInputStream("" + txt);
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (FileNotFoundException e) {
            int a = 1;
            while (a == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Sartu duzun fitxategia ez da existitzen. Berridatzi: ");
                String berria = sc.next();

                if (berria.equals(correctFile)) {
                    in = new FileInputStream(correctFile + txt);
                    out = new FileOutputStream("outagain.txt");
                    int c;
                    sc.close();

                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                    a = 0;

                } else {
                    a = 1;
                }
            }

        } finally {
            if (in != null) {
                System.out.println("Ondo egin da.");
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

