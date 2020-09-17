package entities;

import modelo.Proveedor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Compras")
public class Compras {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate fecha;
    private Double monto_total;
    @OneToOne
    private Proveedores proveedor;

    //TODO: ARREGLAR MAPEO
    /*
    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<MediosDePago> MediosDePago = new ArrayList<>();*/


    private int entidad_id;
    private int entidad_tipo;

    @OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<DocumentoComercial> DocumentosComerciales = new ArrayList<>();

    //TODO: ARREGLAR MAPEO
    /*@OneToMany
    @JoinColumn(name = "compra_id")
    @OrderColumn(name = "numero")
    private List<ItemsDeCompraId> ItemsDeCompra = new ArrayList<>();*/
}