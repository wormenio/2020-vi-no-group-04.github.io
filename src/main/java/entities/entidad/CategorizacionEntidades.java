package entities.entidad;

import entities.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="Categorias_de_entidades")
public class CategorizacionEntidades extends EntidadPersistente {

    @OneToMany
    @JoinColumn(name = "categoria_entidad_id")
    private Collection<Entidad> entidades;
}
