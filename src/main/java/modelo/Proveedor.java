package modelo;


public class Proveedor {
	DireccionPostal direccionPostal;
	String nombre = "";
	String documento = "";
	
	
	public Proveedor(String id, String nombreNuevo, String documentoNuevo, String calle, String altura, String piso) {
		direccionPostal = new DireccionPostal( id,  calle,  altura,  piso);
		nombre = nombreNuevo;
		documento= documentoNuevo;
		
	}
}
