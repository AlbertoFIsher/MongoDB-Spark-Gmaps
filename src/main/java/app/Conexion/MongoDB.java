package app.Conexion;

import app.Calle.Calle;
import app.Colonia.Colonia;
import app.EstacionamientoPublico.EstacionamientosPublicos;
import app.Parquimetro.Parquimetro;
import app.SeccionColonia.Seccion;
import com.mongodb.*;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;
import java.util.List;


public class MongoDB {

    private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "finalBDEFA";
    private static final String DB_COLLECTION = "prueba";

    private MongoClient client;
    private DB database;
    private DBCollection collection;
    private Datastore ds;

    /**
     * Constructor create a client database pool connections     *
     * @throws UnknownHostException
     */
    public MongoDB() throws UnknownHostException {
        this.client = new MongoClient(HOST, PORT);
        this.database = client.getDB(DB_NAME);
        this.collection = database.getCollection(DB_COLLECTION);
        this.ds = new Morphia().createDatastore(client, "finalBDEFA");
    }

    /**
     * @return Any document
     */
    public DBObject getOneDocument() {
        return collection.findOne();
    }

    public void insertDocument(BasicDBObject doc){
        this.collection.insert(doc);
    }

    public List<Calle> getAllCalle(){
        List<Calle> list = this.ds.find(Calle.class).asList();
        if(list != null){
            return list;
        }
        return null;
    }

    public List<Colonia> getAllColonia(){
        List<Colonia> list = this.ds.find(Colonia.class).asList();
        if(list != null){
            return list;
        }
        return null;
    }

    public List<Seccion> getAllSecciones(){
        List<Seccion> list = this.ds.find(Seccion.class).asList();
        if(list != null){
            return list;
        }
        return null;
    }

    public List<EstacionamientosPublicos> getAllEP(){
        List<EstacionamientosPublicos> list = this.ds.find(EstacionamientosPublicos.class).asList();
        if(list != null){
            return list;
        }
        return null;
    }

    public List<Parquimetro> getAllParquimetro(){
        List<Parquimetro> list = this.ds.find(Parquimetro.class).asList();
        if(list != null){
            return list;
        }
        return null;
    }

    public List<Seccion> getOneSeccion(int seccion){

        final List<Seccion> list = this.ds.createQuery(Seccion.class).field("numSeccion").equal(seccion).asList();
        //System.out.println("Despues del query");
        if(list != null){
            return list;
        }
        return null;
    }

    public List<EstacionamientosPublicos> getAllEPSeccion(int seccion ){

        final List<EstacionamientosPublicos> list = this.ds.createQuery(EstacionamientosPublicos.class).field("Seccion").equal(seccion).asList();
       if(list != null) {
           return list;
       }
        return null;
    }

}