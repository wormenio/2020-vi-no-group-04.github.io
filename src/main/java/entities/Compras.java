package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="Proveedores")
public class Compras {
    @Id
    @GeneratedValue
    private int id;

    private LocalDate fecha;
    private Double monto_total;
    private int proveedor_id;
    private int medio_de_pago_id;
    private int medio_de_pago_nro;
    private int documento_comercial_id;

}
