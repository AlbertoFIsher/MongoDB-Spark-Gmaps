package app.Parquimetro;

import org.bson.types.BasicBSONList;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
@Entity
public class Parquimetro {
        @Id
        private int id;
        private int activo;
        private BasicBSONList geometria;

        public Parquimetro(){

        }

        public Parquimetro(int activo, BasicBSONList geometria) {
            this.activo = activo;
            this.geometria = geometria;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getActivo() {
            return activo;
        }

        public void setActivo(int activo) {
            this.activo = activo;
        }

        public BasicBSONList getGeometria() {
            return geometria;
        }

        public void setGeometria(BasicBSONList geometria) {
            this.geometria = geometria;
        }
}
