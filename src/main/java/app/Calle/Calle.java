package app.Calle;

import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
public class Calle {

    @Id
    private int id;
    private String nombreCalle;
    private BasicBSONList geometria;

    public Calle(){

    }
    public Calle(String nombreCalle, BasicBSONList geo) {
        this.nombreCalle = nombreCalle;
        //this.geometria = geo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public BasicBSONList getGeometria() {
        return geometria;
    }

    public void setGeometria(BasicBSONList geo) {
        this.geometria = geo;
    }
}
