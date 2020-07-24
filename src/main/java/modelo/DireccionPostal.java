package modelo;

public class DireccionPostal {
	String calle;
	int altura;
	String piso;
	Pais datosPais;
	SeleccionadorPais seleccionadorPais = new SeleccionadorPais();
	
	public DireccionPostal(Pais pais, String calle, String altura, String piso) {
		
		this.datosPais = pais;
		this.calle= calle;
		this.piso = piso;

	}
}
