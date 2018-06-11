package app.SeccionColonia;

import org.bson.types.BasicBSONList;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Seccion {
    @Id
    private int id;
    private int numSeccion;
    private String nombreSeccion;
    private BasicBSONList geografia;

    public Seccion(){

    }

    public Seccion(int numSeccion, String nombreSeccion, BasicBSONList geografia) {
        this.numSeccion = numSeccion;
        this.nombreSeccion = nombreSeccion;
        this.geografia = geografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumSeccion() {
        return numSeccion;
    }

    public void setNumSeccion(int numSeccion) {
        this.numSeccion = numSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public BasicBSONList getGeografia() {
        return geografia;
    }

    public void setGeografia(BasicBSONList geografia) {
        this.geografia = geografia;
    }

    /*public Polygon getPol(){
        return Polygon.class.cast(this.geografia);

    }*/
}
