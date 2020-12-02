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
/*

    @OneToMany
    @JoinColumn(name = "ciudad_id")
    private Collection<DireccionPostal> direccionesPostales;
*/


}
