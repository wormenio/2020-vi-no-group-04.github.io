package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class Moneda {
   
	APIMlibre api = new APIMlibre("/currencies");

    public Moneda(String currency) {
    	ClientResponse jsonMonedas = api.verInformacion();
		Gson gson = new Gson();

        String monedas = jsonMonedas.getEntity(String.class);
//TODO
//Ver pq no entiende MonedaJson
//    	Type listType = new TypeToken<ArrayList<MonedaJson>>(){}.getType();
//    	ArrayList<MonedaJson> listadoMonedas = gson.fromJson(paises, listType);
	}
	String id;
    String description;
    String symbol;
    int decimal_places;
    
  //  https://api.mercadolibre.com/currencies/

    	 

    
}
