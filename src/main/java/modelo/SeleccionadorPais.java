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
	
	
	public List<RestPais> objetizarPaises(){
		ClientResponse jsonPaises = api.verInformacion();
		Gson gson = new Gson();

        String paises = jsonPaises.getEntity(String.class);
    
    	Type listType = new TypeToken<ArrayList<RestPais>>(){}.getType();
    	ArrayList<RestPais> listadoPaises = gson.fromJson(paises, listType); 
    	return listadoPaises;
	}
	
	public List<Estado> agregarEstados(Pais pais){
		List<Estado> estados =  new ArrayList<>();
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
        								estado.agregarCiudades(this.agregarCiudades(estado));
        								estados.add(estado);
        								
        });	
        
       
        
        							
        return estados; 

        
		
	
	}
	
	private List<Ciudad> agregarCiudades(Estado estado) {
		List<Ciudad> ciudades =  new ArrayList<>();
		APIMlibre api3 = new APIMlibre("classified_locations/states/"+estado.verID());
    	ClientResponse jsonCity = api3.verInformacion();
        String city = jsonCity.getEntity(String.class);

        JsonParser parser2 = new JsonParser();
        
       

        JsonObject gsonObj2 = parser2.parse(city).getAsJsonObject();
        
		Gson gson3 = new Gson();


        Type listType3 = new TypeToken<ArrayList<RestCiudad>>(){}.getType();
        ArrayList<RestCiudad> listadoCity = gson3.fromJson(gsonObj2.get("cities"), listType3); 
		
        listadoCity.forEach((ciudadML)->{
			Ciudad ciudad = new Ciudad(ciudadML.verID(),ciudadML.verNombre());
			ciudad.agregarBarrios(this.agregarBarrios(ciudad));
			ciudades.add(ciudad);
			
}		);
		return ciudades;
		
	}
	private List<Barrio> agregarBarrios(Ciudad ciudad) {
		List<Barrio> barrios =  new ArrayList<>();
		APIMlibre api3 = new APIMlibre("classified_locations/cities/"+ciudad.verID());
    	ClientResponse jsonCity = api3.verInformacion();
        String city = jsonCity.getEntity(String.class);

        JsonParser parser2 = new JsonParser();
        
       

        JsonObject gsonObj2 = parser2.parse(city).getAsJsonObject();
        
		Gson gson3 = new Gson();


        Type listType3 = new TypeToken<ArrayList<RestBarrio>>(){}.getType();
        ArrayList<RestBarrio> listadoNeighbor = gson3.fromJson(gsonObj2.get("neighborhoods"), listType3); 
		
        listadoNeighbor.forEach((barrioML)->{
			Barrio barrio = new Barrio(barrioML.verID(),barrioML.verNombre());
			barrios.add(barrio);
			
}		);
        return barrios;
	}

	public List<Pais> paisesSistema() {

		//FIXME:: MAP
		this.objetizarPaises().forEach((paisML)->{
									Pais pais = new Pais (paisML.verNombre(), paisML.verMoneda(),paisML.verID(), paisML.verLocale());
									pais.agregarEstados(this.agregarEstados(pais));
									
									paises.add(pais);}
		);
		
		return paises;
		
		
	}
}
