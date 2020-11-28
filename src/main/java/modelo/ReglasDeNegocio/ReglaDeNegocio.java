package modelo.ReglasDeNegocio;

import modelo.EntidadPersistente;
import modelo.Entidades.Entidad;

import javax.persistence.*;

@Entity
@Table(name = "Reglas_de_negocio")
@DiscriminatorColumn(name = "tipo_regla")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ReglaDeNegocio extends EntidadPersistente {

    public abstract void aplicarReglaDeNegocio(Entidad entidadOrigen, Entidad entidadDestino);

    public abstract Boolean reglaEsTipoCompra();

    public abstract Boolean reglaEsTipoEntidad();

}
