package modelo;

public class DireccionPostal {
	String calle;
	int altura;
	String piso;
	Pais pais;
	SeleccionadorPais seleccionadorPais = new SeleccionadorPais();
	
	public DireccionPostal(String id, String calle, String altura, String piso) {
		pais = seleccionadorPais.seleccionar(id);

	}
}
