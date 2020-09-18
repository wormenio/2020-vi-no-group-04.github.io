package entities;

import javax.persistence.*;

@Entity
@Table(name = "Medios_de_pago")
public class MediosDePago {
    @EmbeddedId
    MediosDePagoId id;

    private int numero;
}
