package app.Calle;

import app.Conexion.MongoDB;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.List;

import static spark.Spark.halt;

public class CalleController {


    public static MongoDB database;

    public static Route getAllCalles = (Request req, Response resp) -> {


        resp.type("application/json");
        try {

            database  = new MongoDB();
            List<Calle> listaCalle  = database.getAllCalle();
            return listaCalle;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getAllCalle();

    };
}
