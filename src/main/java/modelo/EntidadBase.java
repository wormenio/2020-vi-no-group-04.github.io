package modelo;

public class EntidadBase implements Entidad {
	EntidadJuridica agrupacion;
	String descripcion;
	CategoriaEntidad categoriaEntidad;
	
	public String getNombreFicticio() {	
		return this.descripcion;
	}

	@Override
	public void categorizarEntidad(Integer codigoCategoria, ReglasDeNegocio reglasDeNegocio) {
		categoriaEntidad = new CategoriaEntidad(codigoCategoria,reglasDeNegocio);
	}




}
