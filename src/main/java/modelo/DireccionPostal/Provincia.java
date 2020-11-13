package modelo.DireccionPostal;

import modelo.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Provincias")
public class Provincia extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais pais;

/*    public Provincia(String name) {
        setNombre(name);

    }
    */
//    public  String verNombre() {
//        return nombre;
//    }
//    public  String verID() {
//        return id;
//    }
}
