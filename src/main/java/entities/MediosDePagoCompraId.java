package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MediosDePagoCompraId implements Serializable {
    private int medio_pago_id;
    private int compra_id;
}
