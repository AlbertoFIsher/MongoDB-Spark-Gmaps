package app.Parquimetro;

import app.Conexion.MongoDB;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.List;
import static spark.Spark.halt;

public class ParquimetroController {



    public static MongoDB database;

    public static Route getAllParquimetros = (Request req, Response resp) -> {


        resp.type("application/json");
        try {

            database  = new MongoDB();
            List<Parquimetro> listaSecciones  = database.getAllParquimetro();
            return listaSecciones ;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getAllEP();

    };




}
