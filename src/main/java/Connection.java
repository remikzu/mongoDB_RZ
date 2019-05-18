import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class Connection {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();

        MongoDatabase database = mongoClient.getDatabase("newDB");
        database.createCollection("POJO.Persons");
        database.createCollection("Users");
        for (String listCollectionName : database.listCollectionNames()) {
            System.out.println(listCollectionName);
        }

        MongoCollection<Document> persons = database.getCollection("POJO.Persons");
//        persons.drop();

    }

}
