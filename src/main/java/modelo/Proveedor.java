package modelo;


//import entities.direccionPostal.Calle;
import modelo.DireccionPostal.Calle;
import modelo.DireccionPostal.DireccionPostal;

import javax.persistence.*;

@Entity
@Table(name="Proveedores")
public class Proveedor extends EntidadPersistente{
//	String nombre ;

	private String apellido;

	@Column(name = "razon_social")
	private String razonSocial;
	private String dni;
	private String cuit;

	@ManyToOne
	@JoinColumn(name = "calle_id")
	private Calle calle;

	private int altura;
	private String piso;
	private String departamento;

//	DireccionPostal direccionPostal;

/*
	public Proveedor(String nombre, String apellido, String razonSocial,String dni, String cuit,
					 DireccionPostal direccionPostal) {
		setNombre(nombre);
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.dni = dni;
		this.cuit = cuit;
	}*/

}
