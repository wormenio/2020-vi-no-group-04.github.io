package modelo.CategorizacionEntidad;

import modelo.Entidades.Entidad;
import modelo.ReglasDeNegocioEntidades.ReglasDeNegocioEntidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "categorias_entidades")
public class CategoriaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

  /*  @ManyToMany
    @JoinTable(name = "reglas_de_negocios_de_entidades")*/
    @Transient
    private Collection<ReglasDeNegocioEntidades>  reglasDeNegocio = new ArrayList<>();

    public void agregarReglaDeNegocio(ReglasDeNegocioEntidades unaRegla){

    }

    //TODO -->Aplicar reglas
    public void aplicarReglasDeNegocio(Entidad entidad) {
//        reglasDeNegocio.stream().map( unaRegla -> unaRegla.aplicarReglaDeNegocioEntidad(entidad));
    }



}
