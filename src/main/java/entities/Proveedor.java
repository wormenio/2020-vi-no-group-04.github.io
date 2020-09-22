package entities;

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
    private String calle;
    private int altura;
    private String piso;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

}
