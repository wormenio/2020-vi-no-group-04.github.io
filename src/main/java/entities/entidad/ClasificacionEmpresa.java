package entities.entidad;

import entities.EntidadPersistente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="ClasificacionEmpresa")
public class ClasificacionEmpresa extends EntidadPersistente {
}
