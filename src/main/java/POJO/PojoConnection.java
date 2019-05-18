package POJO;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author Remigiusz Zudzin
 */
public class PojoConnection {

    public static void main(String[] args) {
        CodecRegistry codecRegistry = fromRegistries(
                MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .build();
        com.mongodb.client.MongoClient mongoClient = MongoClients.create(settings);
        MongoCollection<Persons> collection = mongoClient
                .getDatabase("newDB")
                .getCollection("Persons", Persons.class);

        collection.insertOne(new Persons("Hanna", "Nowak", 34));

        collection.deleteOne(eq("name", "Zbigniew"));

        collection.updateOne(eq("name", "Zbigniew"), set("name", "Janusz"));

        collection.updateOne(eq("name", "Hanna"),
                combine(set("name", "Marta"),
                        set("lastName", "Chojnacka"),
                        set("age", 65)));


        for (Persons persons : collection.find()) {
            System.out.println(persons);
        }

    }

}
