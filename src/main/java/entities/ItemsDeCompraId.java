package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemsDeCompraId implements Serializable {
    private Long compra_id;
    private Long item_id;
}
