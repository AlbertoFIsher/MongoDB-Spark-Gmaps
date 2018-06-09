package app.PruebaAjax;

import app.Conexion.MongoDB;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static spark.Spark.halt;

public class PruebaMongoDbController {

    public static  MongoDB database;

    public static Route pruebaMongo = (Request req, Response resp) -> {

            StringWriter writer = new StringWriter();
            String aux;
            try {

               // Template hello = configuration.getTemplate("hello.ftl");
                database  = new MongoDB();
                database.getOneDocument();
                //MongoCollection<Document> collection = database.getCollection("test");
                Document doc = new Document("name", "MongoDB")
                        .append("type", "database")
                        .append("count", 1)
                        .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                        .append("info", new Document("x", 203).append("y", 102));
                aux ="Hizo la consulta";

            } catch (Exception e) {
                halt(500);
                e.printStackTrace();
                aux="No la hizo";
            }
            return aux;


    };



}
