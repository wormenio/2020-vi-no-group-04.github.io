package entities.presupuesto;

import entities.Item;
import entities.ItemsDeCompraId;
import entities.Moneda;

import javax.persistence.*;

@Entity
@Table(name="Items_del_presupuesto")
public class ItemsDelPresupuesto {

    @EmbeddedId
    ItemsDelPresupuestoId id;


    private Double precio;
    private int cantidad;
}
