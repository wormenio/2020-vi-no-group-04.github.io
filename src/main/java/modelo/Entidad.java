package modelo;

import modelo.CategoriaEntidad.ReglasDeNegocio;

public interface Entidad {
	public String getNombreFicticio();

	public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio);

	public Integer getMontoMaximoEgreso();
	public String getTipoEntidad();
}
