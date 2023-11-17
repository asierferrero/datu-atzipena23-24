package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class Csva {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Csva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Csva(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Notak irakurri() {
        Notak notak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = ",";
            String l;
            notak = new Notak();
            while ((l = inputStream.readLine()) != null) {
                String[] eremuak = l.split(banatzailea);
                if (!eremuak[0].equals("ID")) {
                    Nota nota = new Nota();
                    nota.setId(Integer.parseInt(eremuak[0]));
                    nota.setIkaslea(eremuak[1]);
                    nota.setData(eremuak[2]);
                    nota.setIkasgaia(eremuak[3]);
                        nota.setNota(Double.parseDouble(eremuak[4]));
                    notak.add(nota);
                }
            }
            // System.out.println(Notak.getNotak());
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu.");

        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        }
        return notak;
    }

    public int idatzi(Notak Notak) {
        int notaKopurua=0;
        

        try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))) {
            for (Nota n : Notak.getNotak()) {
                if (notaKopurua==0){
                    outputStream.println("ID,IKASLEA,DATA,IKASGAIA,NOTA");
                }
                notaKopurua++;
                
                outputStream.println(n.getId()+","+n.getIkaslea()+","+n.getData()+","+n.getNota());
            }
        } catch (IOException e) {
            System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
        return notaKopurua;
    }
}
