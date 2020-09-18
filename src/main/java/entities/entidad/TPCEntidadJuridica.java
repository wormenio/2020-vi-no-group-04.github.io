package entities.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TPCEntidadJuridica extends TPCEntidad{
  /*  @Id
    @GeneratedValue
    private Long id;*/
    private String razonSocial;
    private String nombreFicticio;
    private String cuit;
    private String direccion_postal;
    private String codigoIGJ;
}
