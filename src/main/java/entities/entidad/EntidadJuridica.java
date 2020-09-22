package entities.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value="EntidadJuridica")
public class EntidadJuridica extends Entidad {
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "nombre_ficticio")
    private String nombreFicticio;
    private String cuit;
    private String direccion_postal;
    private String codigoIGJ;

    @OneToMany
    @JoinColumn(name = "entidad_juridica_id")
    @OrderColumn(name = "id")
    private List<EntidadBase> entidadBase;

    //TODO
    //VER la abstraccion para el nombre
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //TODO
    //VER la abstraccion que representa el nombre del atribuo
    @ManyToOne
    @JoinColumn(name="clasificacion_id")
    private ClasificacionEmpresa clasificacion;
}
