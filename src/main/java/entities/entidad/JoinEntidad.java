package entities.entidad;

import javax.persistence.*;

@Entity
@Table(name="entidad_join")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class JoinEntidad {
    @Id
    @GeneratedValue
    private Long id;


}
