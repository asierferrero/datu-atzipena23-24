package dambi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class JsonFitxategiBatenIdatzi {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject model = Json.createObjectBuilder()
                .add("id", "file")
                .add("value", "File")
                .add("popup", Json.createObjectBuilder()
                        .add("menuitem", Json.createArrayBuilder()
                                .add(Json.createObjectBuilder()
                                        .add("value", "New")
                                        .add("onclick", "createNewDoc()"))
                                .add(Json.createObjectBuilder()
                                        .add("value", "Open")
                                        .add("onclick", "openDoc()"))
                                .add(Json.createObjectBuilder()
                                        .add("value", "Close")
                                        .add("onclick", "closeDoc()"))))
                .build();

        // Print the JSON object
        System.out.println(model);

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("data/Irteera.json"))) {
            jsonWriter.writeObject(model);
        }
    }
}
