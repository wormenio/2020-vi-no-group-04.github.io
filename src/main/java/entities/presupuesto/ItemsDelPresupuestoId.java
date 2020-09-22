package entities.presupuesto;

import javax.persistence.Embeddable;

@Embeddable
public class ItemsDelPresupuestoId {
    private Long item_id;
    private Long presupuesto_id;
}
