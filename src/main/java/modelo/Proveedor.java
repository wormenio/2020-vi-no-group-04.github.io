package modelo;


public class Proveedor {
	DireccionPostal direccionPostal;
	String nombre = "";
	String documento = "";
	
	
	public Proveedor(Pais pais, String nombreNuevo, String documentoNuevo, String calle, String altura, String piso) {
		direccionPostal = new DireccionPostal( pais,  calle,  altura,  piso);
		nombre = nombreNuevo;
		documento= documentoNuevo;
		
	}
}
