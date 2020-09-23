package entities.presupuesto;

import entities.DocumentoComercial;
import entities.Item;
import entities.Moneda;
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

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;
}
