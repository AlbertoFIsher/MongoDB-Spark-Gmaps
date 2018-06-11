package app;

import app.Calle.CalleController;
import app.Colonia.ColoniaController;
import app.EstacionamientoPublico.EstacionamientosPublicosController;
import app.EstacionamientoPublico.EstacionamientosPublicosService;
import app.Parquimetro.ParquimetroController;
import app.SeccionColonia.SeccionController;
import app.user.*;
import app.util.*;
import static spark.Spark.*;
import com.google.gson.Gson;


public class Application {


    public static void main(String[] args) {

        Gson gson = new Gson();
        staticFiles.location("/public");
        get(Path.Web.CALLES,CalleController.getAllCalles,gson::toJson);
        get(Path.Web.COLONIA,ColoniaController.getColonia,gson::toJson);
        get(Path.Web.SECCION,SeccionController.getSecciones,gson::toJson);
        get(Path.Web.ESTACIONAMIENTOS_PUBLICOS,EstacionamientosPublicosController.getAllEP,gson::toJson);
        get(Path.Web.PARQUIMETROS, ParquimetroController.getAllParquimetros,gson::toJson);
        get(Path.Web.SECCCION1,SeccionController.getOneSeccion,gson::toJson);
        get(Path.Web.EP_SECCION,EstacionamientosPublicosService.getEPSeccion,gson::toJson);
    }

}
