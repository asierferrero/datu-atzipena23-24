package dambi.mongo;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import dambi.model.User;

public class MongoAtzipena {

    private String strUri = "mongodb://localhost:1235/?maxPoolSize=20";
    private String strDb = "erronka";
    private String strCol = "jokalariak";

    // public MongoAtzipena(){} ez da beharrezkoa. Inplizituki sortzen da

    public void txertatu(User u) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        try (MongoClient mongoClient = MongoClients.create(strUri)) {
            MongoDatabase database = mongoClient.getDatabase(strDb).withCodecRegistry(pojoCodecRegistry);
            MongoCollection<User> collection = database.getCollection(strCol, User.class);

            InsertOneResult ires = collection.insertOne(u);
            System.out.println("Txertatutako dokumentuaren id-a: " + ires.getInsertedId());
        } catch (Exception ex) {
            System.out.println("Some kind of problem.");
        }

    }
}
