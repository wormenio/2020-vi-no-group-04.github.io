package entities;

import javax.persistence.*;

@Entity
@Table(name = "Medios_de_pago_compra")
public class MediosDePagoCompra {
    @EmbeddedId
    MediosDePagoCompraId id;

    private int numero;
}
