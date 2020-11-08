package modelo;

public class DireccionPostal {
	String calle;
	int altura;
	String piso;
	String departamento;
	Pais datosPais;
	Provincia datosProvincia;
	Ciudad datosCiudad;

	SeleccionadorPais seleccionadorPais = new SeleccionadorPais();
	
	public DireccionPostal(Pais pais, Provincia provincia, Ciudad ciudad, String calle, int altura, String piso, String departamento) {
		
		this.datosPais = pais;
		this.datosProvincia = provincia;
		this.datosCiudad = ciudad;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;

	}
}
