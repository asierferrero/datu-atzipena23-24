package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// import com.mongodb.ReadConcern;
// import com.mongodb.ReadPreference;
// import com.mongodb.TransactionOptions;
// import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;


import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBUmeaRepository implements UmeaRepository {
    // private static final TransactionOptions txnOptions = TransactionOptions.builder()
    //                                                                        .readPreference(ReadPreference.primary())
    //                                                                        .readConcern(ReadConcern.MAJORITY)
    //                                                                        .writeConcern(WriteConcern.MAJORITY)
    //                                                                        .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Umea> umeaCollection;

    @PostConstruct
    void init() {
        umeaCollection = client.getDatabase("gabonak").getCollection("umeak", Umea.class);
    }

    @Override
    public List<Umea> findAll() {
        return umeaCollection.find().into(new ArrayList<>());
    }

    @Override
    public Umea findById(String id) {
        return umeaCollection.find(eq("_id", new ObjectId(id))).first();        
    }

    @Override
    public Umea save(Umea umea) {
        umea.setId(new ObjectId());
        umeaCollection.insertOne(umea);
        return umea;
    }

    @Override
    public long delete(String izena) {
        return umeaCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }

}
