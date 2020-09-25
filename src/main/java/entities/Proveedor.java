package entities;

import entities.direccionPostal.Calle;
import entities.direccionPostal.Ciudad;

import javax.persistence.*;

@Entity
@Table(name="Proveedores")
public class Proveedor {
    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private String apellido;
    private String razon_social;
    private String dni;
    private String cuit;

    @ManyToOne
    @JoinColumn(name = "calle_id")
    private Calle calle;

    private int altura;
    private String piso;
    private String departamento;

}
