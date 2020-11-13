package modelo.Presupuesto;

import modelo.Egreso.Item;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemsDelPresupuestoId implements Serializable {

    @Column(name = "presupuesto_id")
    private Long presupuestoId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
