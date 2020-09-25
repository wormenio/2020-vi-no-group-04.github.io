package entities.direccionPostal;

import entities.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name="Calles")
public class Calle extends EntidadPersistente {

    @ManyToOne
    @JoinColumn(name ="codigo_postal_id" )
    private CodigoPostal codigoPostal;

    @Column(name = "altura_desde")
    private int alturaDesde;

    @Column(name = "altura_hasta")
    private int alturaHasta;

    @Column(name = "paridad_par")
    private Boolean paridadPar;
}
