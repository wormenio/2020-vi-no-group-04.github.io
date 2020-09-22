package entities.direccionPostal;

import entities.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name="Ciudades")
public class Ciudad extends EntidadPersistente {
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;
}
