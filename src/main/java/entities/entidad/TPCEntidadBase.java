package entities.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TPCEntidadBase extends TPCEntidad {
/*    @Id
    @GeneratedValue
    private Long id;*/

    private String nombre;
}
