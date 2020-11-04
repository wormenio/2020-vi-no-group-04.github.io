package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
	
	public List<Estado> estadosSistema(Pais pais){
		List<Estado> estados = null;
		APIMlibre apiEstados = new APIMlibre("classified_locations/countries"+pais.verID());
		ClientResponse jsonEstados = apiEstados.verInformacion();
        String estadosJson = jsonEstados.getEntity(String.class);
        JsonParser parser = new JsonParser();

        JsonObject gsonObj = parser.parse(estadosJson).getAsJsonObject();
        
		Gson gson2 = new Gson();


        Type listType2 = new TypeToken<ArrayList<RestEstado>>(){}.getType();
        ArrayList<RestEstado> listadoEstado = gson2.fromJson(gsonObj.get("states"), listType2);
        
        listadoEstado.forEach((estadoML)->{
        								Estado estado = new Estado(estadoML.verID(),estadoML.verNombre());
        								estados.add(estado);
        								
        });	
        return estados; 

        
		
	}
	public List<Pais> paisesSistema() {

		//FIXME:: MAP
		this.objetizarPaises().forEach((paisML)->{
									Pais pais = new Pais (paisML.verNombre(), paisML.verMoneda(),paisML.verID(), paisML.verLocale());
									pais.agregarEstados(this.estadosSistema(pais));
									
									paises.add(pais);}
		);
	return paises;
		
		
	}
}
