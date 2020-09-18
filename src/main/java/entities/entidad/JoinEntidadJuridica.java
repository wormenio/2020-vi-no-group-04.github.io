package entities.entidad;

import javax.persistence.Entity;

@Entity
public class JoinEntidadJuridica extends JoinEntidad {
    private String razonSocial;
    private String nombreFicticio;
    private String cuit;
    private String direccion_postal;
    private String codigoIGJ;


}
