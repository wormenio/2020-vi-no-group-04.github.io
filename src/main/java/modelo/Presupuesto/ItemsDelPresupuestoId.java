package modelo.Presupuesto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemsDelPresupuestoId implements Serializable {

    @Column(name = "presupuesto_id")
    private Long presupuestoId;

    @Column(name = "item_id")
    private Long itemId;
}
