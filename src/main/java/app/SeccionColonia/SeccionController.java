package app.SeccionColonia;

import app.Conexion.MongoDB;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import static spark.Spark.halt;

public class SeccionController {


    public static MongoDB database;

    public static Route getSecciones = (Request req, Response resp) -> {

        resp.type("application/json");
        try {

            database  = new MongoDB();
            List<Seccion> listaSecciones  = database.getAllSecciones();
            return listaSecciones ;

        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getAllSecciones();

    };


    public static Route getOneSeccion = (Request req, Response resp) -> {

        QueryParamsMap map = req.queryMap();
        int seccion=0;


        resp.type("application/json");
        try {
            if(map.get("a").integerValue() == 1) {
                seccion = 1;
            }else if(map.get("a").integerValue() == 2){
                seccion = 2;
            }else if (map.get("a").integerValue() == 3){
                seccion  =3;
            }
            else if(map.get("a").integerValue() == 4){
                seccion = 4;
            }else if(map.get("a").integerValue() == 5){
                seccion = 5;
            }
            System.out.println(seccion);

            database  = new MongoDB();
            List<Seccion> listaSecciones  = database.getOneSeccion(seccion);

            return listaSecciones ;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }

        return database.getOneSeccion(seccion);

    };




}
