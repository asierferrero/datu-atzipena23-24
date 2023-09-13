package dambi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia lineaz linea irakurtzen du, 
    * linea bakoitza outagain.txt fitxategian idatziz. 
    * Gainera, lerro bakoitzaren hasieran lerro zenbakia inprimatuko du.
    */

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            int i = 1;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(i + ". " + l);
                i++;
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

