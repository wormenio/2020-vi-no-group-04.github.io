package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Items_de_compra")
public class ItemsDeCompra {
    @EmbeddedId
    ItemsDeCompraId id;

    private Double precio;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "moneda_id")
    private Moneda moneda;
}
