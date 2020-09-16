package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedores")
public class Proveedores  {
    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private String apellido;
    private String razon_social;
    private String dni;
    private String cuit;
    private String codigo_postal;

}
