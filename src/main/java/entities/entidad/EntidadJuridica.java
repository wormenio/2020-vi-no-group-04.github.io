package entities.entidad;

import modelo.CategoriaJuridica.CategorizacionEntidadJuridica;
import modelo.CategoriaJuridica.ClasificacionAFIP;

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

    @ManyToOne
    @JoinColumn(name = "categoria_entidad_id")
    private Categoria categoriaEntidad;



    @Enumerated(EnumType.ORDINAL)
    @Column(name="categoria_entidad_juridica")
    private CategorizacionEntidadJuridica categoriaEntidadJuridica;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="clasificacion_afip")
    private ClasificacionAFIP clasificacionAFIP;
}