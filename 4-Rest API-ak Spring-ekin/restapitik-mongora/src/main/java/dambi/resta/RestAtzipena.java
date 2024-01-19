package dambi.resta;

import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

public class RestAtzipena {

    public JsonArray irakurri(URL url) {
        try {

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            JsonReader jsonReader = Json.createReader(con.getInputStream());
            JsonArray jsona = jsonReader.readArray();
            jsonReader.close();
            con.disconnect();

            return jsona;
        } catch (IOException ex) {
            System.out.println("Konekzio arazoa.");
            return null;

        }
    }
}
