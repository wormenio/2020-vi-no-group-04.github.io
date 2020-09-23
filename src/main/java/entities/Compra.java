package entities;

import entities.presupuesto.Presupuesto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Compras")
public class Compra {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fecha;
    private Double monto_total;
    @OneToOne
    private Proveedor proveedor;

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<MediosDePago> MediosDePago = new ArrayList<>();


    private int entidad_id;
    private int entidad_tipo;

    @Column(name="cantidad_presupuesto")
    private int cantidadPresupuestos;

    @Column(name="requiere_presupuesto")
    private Boolean requierePresupuesto;

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<DocumentoComercial> DocumentosComerciales = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<ItemsDeCompra> ItemsDeCompra = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="compra_id")
    private Collection<Presupuesto> presupuestos;

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;


}