package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items_de_compra")
public class ItemsDeCompra {
    @EmbeddedId
    ItemsDeCompraId id;

    private Double monto;
    private int cantidad;
}
