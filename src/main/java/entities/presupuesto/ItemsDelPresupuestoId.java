package entities.presupuesto;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemsDelPresupuestoId  implements Serializable {
    private Long item_id;
    private Long presupuesto_id;
}
