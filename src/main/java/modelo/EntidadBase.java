package modelo;

import entities.entidad.Categoria;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.CategoriaEntidad.ReglasDeNegocio;

public class EntidadBase implements Entidad {
	EntidadJuridica agrupacion;
	static final String tipoEntidad = "BASE";
	String descripcion;
	CategoriaEntidad categoriaEntidad;
	Integer montoMaximoEgreso;

	public EntidadBase(String descripcion, CategoriaEntidad categoriaEntidad){
		this.descripcion = descripcion;
		this.categoriaEntidad = categoriaEntidad;
	}
	
	public String getNombreFicticio() {	
		return this.descripcion;
	}

	@Override
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
		return true;
	}

	@Override
	public Boolean esEntidadJuridica() {
		return false;
	}


}
