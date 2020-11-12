package modelo.CategoriaJuridica;

public class CategoriaEntidadJuridicaOSC implements CategoriaEntidadJuridica {

	public CategorizacionEntidadJuridica getCategoriaEntidadJuridica() {
		return CategorizacionEntidadJuridica.OSC;
	}

	@Override
	public ClasificacionAFIP getClasificacionAFIP(Integer cantidadEmpleados) {
		return null;
	}
}
