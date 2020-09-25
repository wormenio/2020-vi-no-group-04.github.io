package modelo;

public class Empresa implements CategoriaEntidadJuridica {
	ClasificacionAFIP categorizacion;
	
	public String getTipoDeEmpresa()
	{
		return categorizacion.toString();
	}
}
