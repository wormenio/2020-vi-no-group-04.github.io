package modelo;

public interface Entidad {
	public String getNombreFicticio();

	public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio);
}
