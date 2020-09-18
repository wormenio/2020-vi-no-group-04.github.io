package entities.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value="EntidadJuridica")
public class SingleEntidadJuridica extends SingleEntidad {
    private String razonSocial;
    private String nombreFicticio;
    private String cuit;
    private String direccion_postal;
    private String codigoIGJ;

    @OneToMany
    @JoinColumn(name="entidad_juridica_id")
    @OrderColumn(name = "id")
    private List<SingleEntidadBase> entidadBase;
}
