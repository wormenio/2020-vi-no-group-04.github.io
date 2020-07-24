package modelo;

import java.util.HashMap;
import java.util.Map;

public class EtiquetaEgreso {
		
	Map<Integer, String> etiquetas = new HashMap<Integer, String>();
	
	
	public void AgregarEtiqueta(int codigo, String descripcion ) {
		etiquetas.put(codigo,descripcion);
	}
	public void EliminarEtiqueta(int codigo, String descripcion) {
		etiquetas.remove(codigo,descripcion);
	}
	Map<Integer, String> getEtiquetas(){
		return etiquetas;
	}
}


