package dambi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** Programa honek proiektuaren erroan dagoen Xanadu fitxategia bytez byte irakurtzen du, 
    * byte bakoitza outagain.txt fitxategian idatziz.
    */

public class CopyBites {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}

// CopyBytesFNEKontrolatuz: CopyBytes baina mezu aproposa ateraz kopiatu behar duen fitxategia aurkitzen ez badu. Horretarako, FileNotFoundException salbuespena harrapatu beharko duzu. (Ikus SalbuespeneiBuruzkoOinarrizkoAzalpenak edo bertan aipatzen diren iturriak)
// CopyCharactersOrdezkatuz: CopyCharacters programaren antzekoa baina 'a' letra 'o' letrarekin ordezkatuz
// CopyCharactersMaiuskulaz: Irteera fitxategiaren testua maiuskulaz agertuko da.
// CopyLinesZenbakiekin: Lerro bakoitzaren hasieran lerro zenbakia idatziko du.