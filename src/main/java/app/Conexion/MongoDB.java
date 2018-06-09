package app.Conexion;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import org.bson.Document;

import java.net.UnknownHostException;


public class MongoDB {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "pfBDE";
    private static final String DB_COLLECTION = "prueba";

    private MongoClient client;
    private DB database;
    private DBCollection collection;

    /**
     * Constructor create a client database pool connections     *
     * @throws UnknownHostException
     */
    public MongoDB() throws UnknownHostException {
        this.client = new MongoClient(HOST, PORT);
        this.database = client.getDB(DB_NAME);
        this.collection = database.getCollection(DB_COLLECTION);
    }

    /**
     * @return Any document
     */
    public DBObject getOneDocument() {
        return collection.findOne();
    }


}