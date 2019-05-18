import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class MongoDocuments {

    static MongoClient mongoClient = new MongoClient();
    static MongoDatabase database = mongoClient.getDatabase("newDB");
    static MongoCollection<Document> persons = database.getCollection("POJO.Persons");

    static void addDocument (String name, String lastName, int age) {
        persons.insertOne(new Document("name", name).append("lastName", lastName).append("age", age));
    }

    static void addManyDocuments (int amount, String name, String lastName, int age) {

        List<Document> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            list.add(new Document("name", name).append("lastName", lastName).append("age", age));
        }

        persons.insertMany(list);
    }

    static void countElements (MongoCollection<Document> collection) {
        System.out.println(collection.countDocuments());
    }

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("newDB");
        MongoCollection<Document> persons = database.getCollection("POJO.Persons");


        Document document = new Document("name", "Remik")
                .append("lastName", "Zudzin")
                .append("age", 25);

//        addDocument("Dawid", "Kamasz", 30);

//        long start = System.currentTimeMillis();
//
        addManyDocuments(15, "Joanna", "Zielinska", 40);
//
//        long stop = System.currentTimeMillis();
//
//        System.out.println((stop-start)/1000);

//        countElements(persons);
    }

}
