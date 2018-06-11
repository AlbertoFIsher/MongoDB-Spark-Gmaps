package app.Colonia;

import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Colonia {
    @Id
    private int id;
    private String colonia;
    private BasicBSONList geografia;

    public Colonia(){

    }
    public Colonia(String colonia, BasicBSONList geografia) {
        this.colonia = colonia;
        this.geografia = geografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public BasicBSONList getGeografia() {
        return geografia;
    }

    public void setGeografia(BasicBSONList geografia) {
        this.geografia = geografia;
    }
}
