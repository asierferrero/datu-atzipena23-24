package dambi.atzipenekoak;

import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class JsonNotak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonNotak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonNotak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Notak irakurri() {
        Notak notak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();

            notak = new Notak();

            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Nota nota = new Nota();
                nota.setId(jsonobj.getInt("id"));
                nota.setIkaslea(jsonobj.getString("ikaslea"));
                nota.setData(jsonobj.getString("data"));
                nota.setIkasgaia(jsonobj.getString("ikasgaia"));
                nota.setNota(jsonobj.getInt("nota"));
                notak.add(nota);
            }

        } catch (Exception e) {
            System.out.println("Ezin izan da " + strFileIn + " fitxategia irakurri.");
        }
        return notak;
    }

   
}
