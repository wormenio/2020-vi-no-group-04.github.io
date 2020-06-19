package modelo;

public class DireccionPostal {
	String calle;
	int altura;
	String piso;
	Pais datosPais;
	SeleccionadorPais seleccionadorPais = new SeleccionadorPais();
	
	public DireccionPostal(String id, String calle, String altura, String piso) {
		datosPais = seleccionadorPais.seleccionar(id);

	}
}
