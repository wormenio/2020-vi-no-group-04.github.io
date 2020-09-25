package entities.presupuesto;

import entities.DocumentoComercial;
import entities.DocumentoComercialCompra;
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

    private LocalDate fecha;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private DocumentoComercial documentoComercial;

    @OneToMany
    @JoinColumn(name="presupuesto_id")
    private Collection<ItemsDelPresupuesto> itemsDelPresupuesto;




//    @ManyToOne
//    @JoinColumn(name = "moneda_id")
//    private Moneda moneda;
}
