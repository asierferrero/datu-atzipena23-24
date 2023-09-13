package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia irakurtzen du, 
    * karaktere bakoitza characteroutput.txt fitxategian idatziz.
    * Gainera, xanadu.txt fitxategian "a" letra irakurtzen duen bakoitzean characteroutput.txt fitxategian "o" letra idatziko du.
    */

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                if (c == 'a') {
                    c = 'o';
                }
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
