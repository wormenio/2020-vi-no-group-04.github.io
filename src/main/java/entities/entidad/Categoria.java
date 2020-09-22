package entities.entidad;

import entities.EntidadPersistente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="Categorias")
public class Categoria extends EntidadPersistente {
}
