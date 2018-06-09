package app.PruebaAjax;

import app.util.Path;
import app.util.ViewUtil;
//import org.omg.CORBA.NameValuePair;
//import org.omg.CORBA.NameValuePair;
import spark.Request;
import spark.Response;
import spark.Route;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static app.Application.bookDao;
import static app.util.JsonUtil.dataToJson;
import static app.util.RequestUtil.clientAcceptsHtml;
import static app.util.RequestUtil.clientAcceptsJson;
/**************************************/
import static spark.Spark.*;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.QueryParamsMap;
public class PruebaAjaxController {



    public static Route sumaAjax = (Request req, Response resp) -> {
        QueryParamsMap map = req.queryMap();
        try {
            Integer a = map.get("a").integerValue();
            Integer b = map.get("b").integerValue();
            return "A:"+a +" B: "+ b +" Res: "+(a+b);
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }

    };

    public static Route sumaAjaxJson = (Request req, Response resp) -> {
        List<NameValuePair> pairs = URLEncodedUtils.parse(req.body(), Charset.defaultCharset());

        Map<String, String> params = toMap(pairs);

        try {
            Integer a = Integer.parseInt(params.get("a"));
            Integer b = Integer.parseInt(params.get("b"));
            return a + b;
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }

    };

    private static Map<String, String> toMap(List<NameValuePair> pairs){
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<pairs.size(); i++){
            NameValuePair pair = pairs.get(i);
            map.put(pair.getName(), pair.getValue());
        }
        return map;
    }
}
