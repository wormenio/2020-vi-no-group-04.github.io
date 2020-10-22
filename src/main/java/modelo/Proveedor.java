package modelo;


public class Proveedor {
	DireccionPostal direccionPostal;
	String nombre = "";
	String documento = "";
	
	
	public Proveedor(String nombreNuevo, String documentoNuevo, DireccionPostal direccionPostal) {
		direccionPostal = direccionPostal;
		nombre = nombreNuevo;
		documento= documentoNuevo;
		
	}
}
