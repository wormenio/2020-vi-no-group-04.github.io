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

	
	public APIMlibre(String path) {
        response = (Client.create()
            .resource("https://api.mercadolibre.com/")
           .path(path)
           .accept(MediaType.APPLICATION_JSON)
           .get(ClientResponse.class));
        
    	
    }
	
	public ClientResponse verInformacion() {
		return response;
	}
	
	
	
	


	
}
