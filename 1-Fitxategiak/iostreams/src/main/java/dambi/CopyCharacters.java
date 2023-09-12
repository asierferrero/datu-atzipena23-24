package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia irakurtzen du, 
    * karaktere bakoitza characteroutput.txt fitxategian idatziz.
    * (CopyCharacters-en, "int" aldagaiak bere azken 16 bitetan du karaktere-balioa; CopyBytesen, "int" aldagaiak byte balioa du bere azken 8 bitetan.)
    */

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
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
