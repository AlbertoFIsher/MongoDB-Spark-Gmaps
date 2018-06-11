package app.EstacionamientoPublico;

import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class EstacionamientosPublicos {
    @Id
    private int id;
    private String nombreE;
    private int Seccion;
    private BasicBSONList geometria;
    private int lugaresDisponibles;


    public EstacionamientosPublicos(){

    }

    public EstacionamientosPublicos(String nombreE, BasicBSONList geometria, int lugaresDisponibles) {
        this.nombreE = nombreE;
        this.geometria = geometria;
        this.lugaresDisponibles = lugaresDisponibles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public BasicBSONList getGeometria() {
        return geometria;
    }

    public void setGeometria(BasicBSONList geometria) {
        this.geometria = geometria;
    }

    public int getLugaresDisponibles() {
        return lugaresDisponibles;
    }

    public void setLugaresDisponibles(int lugaresDisponibles) {
        this.lugaresDisponibles = lugaresDisponibles;
    }

    public int getSeccion() {
        return Seccion;
    }

    public void setSeccion(int seccion) {
        Seccion = seccion;
    }
}
