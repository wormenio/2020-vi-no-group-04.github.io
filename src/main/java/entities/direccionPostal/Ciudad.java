package entities.direccionPostal;

import entities.EntidadPersistente;
import entities.Proveedor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Ciudades")
public class Ciudad extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @ManyToMany
    private Collection<Proveedor> proveedores;
}
