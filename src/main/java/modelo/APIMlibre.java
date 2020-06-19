package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;



public class  APIMlibre {
	private ClientResponse response;

	
	public APIMlibre() {
        response = (Client.create()
            .resource("https://api.mercadolibre.com/")
           .path("classified_locations/countries")
           .accept(MediaType.APPLICATION_JSON)
           .get(ClientResponse.class));
        
    	
    }
	
	public List<Pais> verPaises() {
		Gson gson = new Gson();

        String paises = response.getEntity(String.class);
    	
    	Type listType = new TypeToken<ArrayList<Pais>>(){}.getType();
    	ArrayList<Pais> listadoPaises = gson.fromJson(paises, listType); 
    	
    	return listadoPaises;
	}
	
	
	


	
}
