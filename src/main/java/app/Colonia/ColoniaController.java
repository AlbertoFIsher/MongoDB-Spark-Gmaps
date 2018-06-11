package app.Colonia;

import app.Conexion.MongoDB;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.List;
import static spark.Spark.halt;

public class ColoniaController {

    public static MongoDB database;

    public static Route getColonia = (Request req, Response resp) -> {


        resp.type("application/json");
        try {

            database  = new MongoDB();
            List<Colonia> listaColonia  = database.getAllColonia();
            return listaColonia;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getAllColonia();

    };






}
