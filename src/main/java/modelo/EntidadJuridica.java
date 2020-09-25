package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.CategoriaEntidad.ReglasDeNegocio;

import java.util.ArrayList;
import java.util.List;

public class EntidadJuridica implements Entidad {
	EntidadJuridica agrupacion;
	static final String tipoEntidad = "ENTIDADJURIDICA";
	int cuit;
	String razonSocial;
	DireccionPostal direccionPostal;
	int codigoIGJ;
	CategoriaEntidadJuridica categoria;
	List<EntidadBase> conformadaPor = new ArrayList<EntidadBase> ();
	CategoriaEntidad categoriaEntidad;
	Integer montoMaximoEgreso;
	
	public String getNombreFicticio()
	{
		return razonSocial;
	}

	public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio) {
		categoriaEntidad = new CategoriaEntidad(codigoCategoria,reglasDeNegocio);
	}

	public Integer getMontoMaximoEgreso(){
		return montoMaximoEgreso;
	}

	public String getTipoEntidad(){
		return tipoEntidad;
	}

	@Override
	public Boolean esEntidadBase() {
		return false;
	}

	@Override
	public Boolean esEntidadJuridica() {
		return true;
	}

	//�Como agrego una base aca? - Falta metodo
}
