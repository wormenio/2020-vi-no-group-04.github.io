package modelo;


public class Proveedor {
	String nombre ;
	String apellido;
	String razonSocial;
	String dni;
	String cuit;
	DireccionPostal direccionPostal;


	public Proveedor(String nombre, String apellido, String razonSocial,String dni, String cuit,
					 DireccionPostal direccionPostal) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.dni = dni;
		this.cuit = cuit;
		this.direccionPostal = direccionPostal;
	}
}
