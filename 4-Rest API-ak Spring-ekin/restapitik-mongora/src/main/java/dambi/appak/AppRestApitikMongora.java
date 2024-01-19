package dambi.appak;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

import dambi.model.User;
import dambi.mongo.MongoAtzipena;
import dambi.resta.RestAtzipena;
/**
 * mvn compile exec:java -Dexec.mainClass="dambi.appak.AppRestApitikMongora"
 *
 */
public class AppRestApitikMongora {
    /**
     * @throws URISyntaxException  */
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URI("https://jsonplaceholder.typicode.com/users").toURL();
       
        MongoAtzipena ma = new MongoAtzipena();
        RestAtzipena ra = new RestAtzipena();

        JsonArray jsona = ra.irakurri(url);
        
        for (JsonValue jValue : jsona) {
            User user = new User();
            JsonObject jObject = jValue.asJsonObject(); 
            user.setIdJokalari(jObject.getInt("id"));
            user.setEmail(jObject.getString("email"));
            user.setSoldata(1300);

            // if (!MongoAtzipena.bilatu(user))
            ma.txertatu(user);

        }

        // System.out.println("Objektu kopurua: "+jsona.size());
        // System.out.println("forEach metodoarekin\n============================");
        // jsona.forEach(e->System.out.println(e));

        // System.out.println("Enhanhed for batekin\n============================");
        
        // System.out.println(jsona.toString());

    }
}
