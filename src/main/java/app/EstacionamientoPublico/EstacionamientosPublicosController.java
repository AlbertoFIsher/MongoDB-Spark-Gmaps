package app.EstacionamientoPublico;

import app.Conexion.MongoDB;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

import static spark.Spark.halt;

public class EstacionamientosPublicosController {

    public static MongoDB database;

    public static Route getAllEP = (Request req, Response resp) -> {


        resp.type("application/json");
        try {

            database  = new MongoDB();
            List<EstacionamientosPublicos> listaSecciones  = database.getAllEP();
            return listaSecciones ;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getAllEP();

    };




}
