package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "items_de_compra")
public class ItemsDeCompra {
    @EmbeddedId
    ItemsDeCompraId id;
    private Double monto;
    private int cantidad;
}
