package com.makitigroup.training.Service;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.stereotype.Service;

@Service
public class HealthService {


    public Document getDatabaseConnexionHealthy(){

        String uri = "mongodb+srv://ivanuser:8ywxt2nYlttqeyuP@awsfracluster01.ydyazub.mongodb.net/demo_spring";
        MongoProperties mongoProperties = new MongoProperties();
        mongoProperties.setUri(uri);

        Document commandResult = new Document();
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("admin");
            try {
                Bson command = new BsonDocument("ping", new BsonInt64(1));
                commandResult = database.runCommand(command);
                System.out.println("Connected successfully to server. Command Result: s" + commandResult);
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
        }
        return commandResult;

    }

}
