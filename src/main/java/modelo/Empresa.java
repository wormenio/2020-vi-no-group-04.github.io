package modelo;

public class Empresa implements CategoriaEntidadJuridica {
	CategorizacionAFIP categorizacion;
	
	public String getTipoDeEmpresa()
	{
		return categorizacion.toString();
	}
}
