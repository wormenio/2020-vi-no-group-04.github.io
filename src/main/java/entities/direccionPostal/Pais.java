package entities.direccionPostal;

import entities.EntidadPersistente;
import entities.Moneda;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Paises")
public class Pais extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
