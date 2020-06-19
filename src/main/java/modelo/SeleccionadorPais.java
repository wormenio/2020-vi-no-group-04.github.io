package modelo;

import java.util.List;

public class SeleccionadorPais {
    List<Pais> paises;
	public SeleccionadorPais() {
		APIMlibre api = new APIMlibre();
		paises= api.verPaises();
		
	}
	
	public Pais seleccionar(String id) {
		for(int i= 0; i< paises.size(); i++) {
			if(paises.get(i).verID() == id) {
				return paises.get(i);
			}
		}
		return null;
	}
}
