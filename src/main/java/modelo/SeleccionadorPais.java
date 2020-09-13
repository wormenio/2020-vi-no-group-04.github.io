package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class SeleccionadorPais {
    List<Pais> paises;
    APIMlibre api = new APIMlibre("classified_locations/countries");
	
	
	public List<PaisJson> objetizarPaises(){
		ClientResponse jsonPaises = api.verInformacion();
		Gson gson = new Gson();

        String paises = jsonPaises.getEntity(String.class);
    
    	Type listType = new TypeToken<ArrayList<PaisJson>>(){}.getType();
    	ArrayList<PaisJson> listadoPaises = gson.fromJson(paises, listType); 
    	return listadoPaises;
	}
	
	public List<Pais> paisesSistema() {
			
		this.objetizarPaises().forEach((paisML)->{
									Pais pais = new Pais (paisML.verNombre(), paisML.verMoneda(),paisML.verID(), paisML.verLocale());
									paises.add(pais);}
		);
	return paises;
		
		
	}
}
