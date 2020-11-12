package modelo.CategoriaEntidad;

import modelo.Entidades.Entidad;

import javax.persistence.*;

@Entity
@Table(name = "categorias_entidades")
public class CategoriaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Transient
    private ReglasDeNegocio reglasDeNegocio;


//    public CategoriaEntidad(String nombreCategoria){ this.nombre = nombreCategoria; }

    //TODO -->Aplicar reglas
    public boolean aplicarReglasDeNegocio(Integer monto_compra, Entidad entidad) {
        return reglasDeNegocio.aplicarReglasDeNegocio(monto_compra, entidad);
    }

}
