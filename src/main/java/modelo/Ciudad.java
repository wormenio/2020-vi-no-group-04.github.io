package modelo;

import modelo.DireccionPostal.Barrio;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String id;
    String nombre;
    List<Barrio> barrios = new ArrayList<>();
    public Ciudad(String name, String id) {
        this.id = id;
        this.nombre = name;
    }
    public  String verNombre() {
        return nombre;
    }
    public  String verID() {
        return id;
    }
	public void agregarBarrios(List<Barrio> barriosImportados) {
		barrios.addAll(barriosImportados);

	}
}
