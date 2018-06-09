package app;

//import app.book.*;
//import app.index.*;
//import app.login.*;
import app.user.*;
import app.PruebaAjax.*;
import app.util.*;
import static spark.Spark.*;
import spark.QueryParamsMap;
import static spark.debug.DebugScreen.*;

public class Application {

    // Declare dependencies
    //public static BookDao bookDao;
    public static UserDao userDao;

    public static void main(String[] args) {
/*
        // Instanciando las depednencias
        //bookDao = new BookDao();
        userDao = new UserDao();

        // Configurando Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        /*get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.BOOKS,          BookController.fetchAllBooks);
        get(Path.Web.ONE_BOOK,       BookController.fetchOneBook);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);
        get("*",                     ViewUtil.notFound);*/

        /*get(Path.Web.PRUEBA_AJAX,PruebaAjaxController.sumaAjax);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);*/


        staticFiles.location("/public");
        get(Path.Web.PRUEBA_AJAX,PruebaAjaxController.sumaAjax);
        post(Path.Web.PRUEBA_AJAX_JSON,PruebaAjaxController.sumaAjaxJson);
        get(Path.Web.PRUEBA_MONGODB,PruebaMongoDbController.pruebaMongo);
        /*get("/api/sum", (req, res) -> {
            QueryParamsMap map = req.queryMap();
            try {
                Integer a = map.get("a").integerValue();
                Integer b = map.get("b").integerValue();
                return a + b;
            }
            catch (Exception e){
                return "Error: " + e.getMessage();
            }
        });*/
    }

}
