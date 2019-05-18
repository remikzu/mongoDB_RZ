import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class MongoSelectExamples {

    public static void main(String[] args) {
        MongoDatabase mongoDatabase = getMongoDatabase();
        MongoCollection<Document> persons = mongoDatabase.getCollection("POJO.Persons");

//        Document document = new Document("name", "Remik")
//                .append("lastName", "Zudzin")
//                .append("age", 25);

//        persons.insertOne(document);

//        for (Document document : persons.find()) {
//            System.out.println(document);
//            System.out.println(document.toJson());
//        }

//        Document document = persons.find().first();
//        System.out.println(document.toJson());
//
//        Document first = persons.find(Filters.eq("name", "TestName")).first();
//        System.out.println(first.toJson());

//        getAllElements(persons);
//        getFilteredElement(persons, "Remik").forEach(System.out::println);
        System.out.println(getFirstFilteredElement(persons, "Remik"));
    }

    static void getAllElements(MongoCollection<Document> collection) {
        for (Document document :
                collection.find()) {
            System.out.println(new Document(document));
        }
    }

    static List<Document> getFilteredElement(MongoCollection<Document> collection, String name) {

        List<Document> list = new ArrayList<>();

        for (Document document :
                collection.find(Filters.eq("name", name))) {
            list.add(new Document(document));
        }

        return list;
    }

    static Document getFirstFilteredElement(MongoCollection<Document> collection, String name) {
        return collection.find(Filters.eq("name", name)).first();
    }

    static MongoDatabase getMongoDatabase() {
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase("newDB");
    }

}
