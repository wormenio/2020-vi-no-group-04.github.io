package modelo.DocumentoComercial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Remito")
public class Remito extends DocumentoComercial {
 /*   Integer numero;

    public Remito(Integer nroTicket){
        this.numero = numero;
    }

    @Override
    public Integer getNumero() {
        return this.numero;
    }
*/
}
