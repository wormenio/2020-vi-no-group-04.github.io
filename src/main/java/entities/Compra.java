package entities;

import entities.entidad.Entidad;
import entities.presupuesto.Presupuesto;
import entities.usuario.UsuarioEntity;
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

    @OneToOne
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="entidad_id")
    private Entidad entidad;

    private LocalDate fecha;

    private Double monto_total;

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;

    @Column(name="requiere_presupuesto")
    private Boolean requierePresupuesto;

    @Column(name="cantidad_presupuesto")
    private int cantidadPresupuestos;

    private Boolean validado;

    @OneToOne
    @JoinColumn(name = "presupuesto_seleccionado_id")
    private Presupuesto presupuestoSeleccionado;

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<MediosDePagoCompra> MediosDePago = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<DocumentoComercialCompra> DocumentosComerciales = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<ItemsDeCompra> ItemsDeCompra = new ArrayList<>();

    @OneToMany
    @JoinColumn(name="compra_id")
    private Collection<Presupuesto> presupuestos;

    @ManyToMany
    private Collection<EtiquetaEntity> etiquetas;

    @ManyToMany
    private Collection<UsuarioEntity> usuario;
}