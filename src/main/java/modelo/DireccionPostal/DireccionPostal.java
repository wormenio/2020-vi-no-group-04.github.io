package modelo.DireccionPostal;

//import entities.entidad.Entidad;
import modelo.EntidadPersistente;
//import modelo.SeleccionadorPais;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direcciones_postales")
public class DireccionPostal extends EntidadPersistente {

	@ManyToOne
	@JoinColumn(name = "id_ciudad")
	private Ciudad ciudad;

	/*
	Private String calle;
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

	 */

}
