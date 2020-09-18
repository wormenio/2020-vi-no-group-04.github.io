package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MediosDePagoId implements Serializable {
    private int tipo_medio_pago_id;
    private int compra_id;
}
