package modelo;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	private String id;
	private String nombre;
	
	List<Ciudad> ciudades = new ArrayList<>();
	
	public Estado(String id, String name) {
		this.nombre=name;
		this.id = id;
	}
	public void agregarCiudades(List<Ciudad> ciudadesImportadas) {
		ciudades.addAll(ciudadesImportadas);
	}
	public String verID() {
		return id;
	}
}
