package entities.direccionPostal;

import entities.EntidadPersistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Provincias")
public class Provincia  extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais pais;

}
