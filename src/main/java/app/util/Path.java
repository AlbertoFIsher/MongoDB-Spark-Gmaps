package app.util;

import lombok.*;

public class Path {


    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String CALLES = "/api/getAllCalles";
        @Getter public static final String COLONIA = "/api/getColonia";
        @Getter public static final String SECCION = "/api/getSecciones";
        @Getter public static final String ESTACIONAMIENTOS_PUBLICOS = "/api/getAllEP";
        @Getter public static final String PARQUIMETROS = "/api/getAllParquimetros";
        @Getter public static final String SECCCION1 = "/api/getSeccion";
        @Getter public static final String EP_SECCION = "/api/getEPSeccion";
         public static final String PRUEBA_AJAX_JSON = "/api/json";

    }



}
