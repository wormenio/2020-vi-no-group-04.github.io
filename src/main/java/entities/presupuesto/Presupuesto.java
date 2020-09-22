package entities.presupuesto;

import entities.Item;
import entities.Proveedor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="Presupuestos")
public class Presupuesto {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Proveedor proveedor;

    private LocalDate fecha;

    @OneToMany
    @JoinColumn(name="presupuesto_id")
    private Collection<ItemsDelPresupuesto> itemsDelPresupuesto;

}
