package modelo.DireccionPostal;

//import entities.direccionPostal.CodigoPostal;
//import entities.direccionPostal.Provincia;
import modelo.EntidadPersistente;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Ciudades")
public class Ciudad  extends EntidadPersistente  {

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @OneToMany
    private Collection<DireccionPostal> direccionesPostales;

  /*
    public Ciudad(String name, String id) {
        this.id = id;
        this.nombre = name;
    }
    public  String verNombre() {
        return nombre;
    }
    public  String verID() {
        return id;
    }*/
}
