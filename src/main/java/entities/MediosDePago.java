package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Medios_de_pago")
public class MediosDePago {
    private int tipo_medio_pago;
    private int numero;
    private int compra_id;
}
