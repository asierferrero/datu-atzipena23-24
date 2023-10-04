package dambi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;


public class JsonFitxategiaIrakurri {
    public static void main(String[] args) {
        try {
            jsonIrakurri();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void jsonIrakurri() throws FileNotFoundException {
        JsonReader reader = Json.createReader(new FileReader("./data/Irteera.json"));
        JsonStructure jsonst = reader.read();
        System.out.println(jsonst);
    }
}
