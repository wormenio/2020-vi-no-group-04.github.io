package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class SeleccionadorPais {
    List<Pais> paises;
    APIMlibre api = new APIMlibre();
	
	
	public List<PaisJson> objetizarPaises(){
		ClientResponse jsonPaises = api.verPaisesAPI();
		Gson gson = new Gson();

        String paises = jsonPaises.getEntity(String.class);
    
    	Type listType = new TypeToken<ArrayList<PaisJson>>(){}.getType();
    	ArrayList<PaisJson> listadoPaises = gson.fromJson(paises, listType); 
    	return listadoPaises;
	}
	
	public Pais seleccionar(String id) {
		
		
		for(int i= 0; i< this.objetizarPaises().size(); i++) {
			if(this.objetizarPaises().get(i).verID() == id) {
				 Pais pais = new Pais (this.objetizarPaises().get(i).verNombre(), this.objetizarPaises().get(i).verMoneda());
				 return pais;
			}
		}
		return null;
	}
}
