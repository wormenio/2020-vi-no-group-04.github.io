package entities.entidad;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="EntidadBase")
public class SingleEntidadBase extends SingleEntidad {
    private String nombre;
}
