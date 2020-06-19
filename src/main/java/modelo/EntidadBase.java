package modelo;

public class EntidadBase implements Entidad {
	EntidadJuridica agrupacion;
	String descripcion;
	
	public String getNombreFicticio() {	
		return this.descripcion;
	}
	
}
