package app.EstacionamientoPublico;

import app.Conexion.MongoDB;
import app.SeccionColonia.Seccion;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;
import spark.Route;


import java.util.List;

import static spark.Spark.halt;

public class EstacionamientosPublicosService {
        public static MongoDB database;
        public static List<Seccion> listaSecciones;

    public static Route getEPSeccion = (Request req, Response resp) -> {

        QueryParamsMap map = req.queryMap();
        int seccion=0;

        System.out.println("entro service");
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
            database  = new MongoDB();
            List<EstacionamientosPublicos> listaEP  = database.getAllEPSeccion(seccion);

            return listaEP;


        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
            //aux="No la hizo";
        }
        //Polygon pol = Polygon.class.cast(listaSecciones.get(0));
        return  database.getAllEPSeccion(seccion);

    };
}
