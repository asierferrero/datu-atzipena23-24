package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Mendia;
import dambi.pojoak.Mendiak;

public class Jsona {
    public String strFileIn;
    private String strFileOut;

    public Jsona(String fileIn) {
        this.strFileIn = fileIn;
    }

    public Jsona(String fileIn, String fileOut) {
        this.strFileIn = fileIn;
        this.strFileOut = fileOut;
    }

    public Mendiak irakurri() {
        Mendiak mendiak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            mendiak = new Mendiak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Mendia mendia = new Mendia();
                mendia.setId(jsonobj.getInt("id"));
                mendia.setMendia(jsonobj.getString("mendia"));
                mendia.setAltuera(jsonobj.getString("altuera"));
                mendia.setProbintzia(jsonobj.getString("probintzia"));
                mendiak.add(mendia);
            }
        } catch (Exception e) {
            System.out.println("Ezin izan da " + strFileIn + " fitxategia irakurri.");
        }
        return mendiak;
    }

    public int idatzi(Mendiak mendiak) throws FileNotFoundException {
        int mendiKop = 0;

        for (Mendia mendia : mendiak.getMendiak()) {
            JsonArray model = Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                    .add("id", mendia.getId())
                    .add("mendia", mendia.getMendia())
                    .add("altuera", mendia.getAltuera())
                    .add("probintzia", mendia.getProbintzia()))
                    .build();

            mendiKop++;

            try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
                jsonWriter.writeArray(model);
            } catch (Exception e) {
                System.out.println("Arazoa egon da " + strFileIn + " fitxategiarekin.");
            }
        }
        return mendiKop;
    }
}
