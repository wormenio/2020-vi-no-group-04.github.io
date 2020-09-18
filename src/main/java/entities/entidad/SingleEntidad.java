package entities.entidad;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="tipo_entidad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SingleEntidad {
    @Id
    @GeneratedValue
    private Long id;

}
