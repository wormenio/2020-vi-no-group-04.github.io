package modelo.CategorizacionEntidad;

import modelo.EntidadPersistente;
import modelo.Entidades.Entidad;
import modelo.ReglasDeNegocio.ReglaDeNegocio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "categorias_entidades")
public class CategoriaEntidad extends EntidadPersistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "reglas_de_negocio_de_la_categoria")
    private Collection<ReglaDeNegocio> reglasDeNegocios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void agregarReglaDeNegocio(ReglaDeNegocio reglaDeNegocio){
        reglasDeNegocios.add(reglaDeNegocio);
    }

    public Collection<ReglaDeNegocio> getReglasDeNegocios() {
        return reglasDeNegocios;
    }


    public void validarReglasDeNegocioDelEgreso(Entidad entidadOrigen, Entidad entidadDestino){
        reglasDeNegocios.stream()
                .filter( reglaDeNegocio -> reglaDeNegocio.reglaEsTipoEntidad() )
                .forEach(   reglaDeNegocio ->
                        reglaDeNegocio.aplicarReglaDeNegocio( entidadOrigen, entidadDestino )
                );
    }

    public void validarReglasDeNegocioDeLaEntidad(Entidad entidadOrigen, Entidad entidadDestino){
        reglasDeNegocios.stream()
                .filter(  reglaDeNegocio -> reglaDeNegocio.reglaEsTipoEntidad() )
                .forEach(   reglaDeNegocio ->
                        reglaDeNegocio.aplicarReglaDeNegocio(entidadOrigen,entidadDestino)
                );
    }

}
