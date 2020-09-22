package entities.entidad;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Entidades")
@DiscriminatorValue(value="EntidadBase")
public class EntidadBase extends Entidad {
    private String nombre;
}
