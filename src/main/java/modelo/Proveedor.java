package modelo;


public class Proveedor {
	String nombre ;
	String apellido;
	String razonSocial;
	String dni;
	String cuit;
	DireccionPostal direccionPostal;
	String piso;
	String departamento;


	public Proveedor(String nombre, String apellido, String razonSocial,String dni, String cuit,
					 DireccionPostal direccionPostal,String piso, String departamento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.dni = dni;
		this.cuit = cuit;
		this.direccionPostal = direccionPostal;
		this.piso= piso;
		this.departamento = departamento;
	}
}
