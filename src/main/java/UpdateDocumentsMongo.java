import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

/**
 * @author Remigiusz Zudzin
 */
public class UpdateDocumentsMongo {

    public static void main(String[] args) {

        MongoDatabase mongoDatabase = MongoSelectExamples.getMongoDatabase();

        MongoCollection collection = mongoDatabase.getCollection("POJO.Persons");

//        UpdateResult updateResult = collection.updateMany(Filters.eq("name", "Zbigniew"),
//                new Document("$set", new Document("age", 35)));
//
//        long matchedCount = updateResult.getMatchedCount();
//        System.out.println(matchedCount);
//
//        DeleteResult deleteResult = collection.deleteOne(Filters.eq("name", "TestName"));
//        long deletedCount = deleteResult.getDeletedCount();
//        System.out.println(deletedCount);

//        updateAllDocuments(collection, 20, 21);
//        deleteManyDocuments(collection, 15);
//        deleteOneDocument(collection, 35);

    }

    static UpdateResult updateAllDocuments(MongoCollection<Document> collection, int age, int ageLimit) {
        return collection.updateMany(Filters.gt("age", ageLimit),
                new Document("$set", new Document("age", age)));
    }

    static DeleteResult deleteManyDocuments(MongoCollection<Document> collection, int age) {
        return collection.deleteMany(Filters.eq("age", age));
    }

    static DeleteResult deleteOneDocument(MongoCollection<Document> collection, int age) {
        return collection.deleteOne(Filters.eq("age", age));
    }

}
