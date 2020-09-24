package entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="Etiquetas")
public class Etiqueta extends EntidadPersistente {

    @ManyToMany
    private Collection<Proveedor> proveedores;
}