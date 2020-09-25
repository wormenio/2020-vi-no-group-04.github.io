package modelo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;

public class Moneda {
   
    String id;
    String description;
    String symbol;
    int decimal_places;

    public Moneda(String currency) {
        symbol=currency;
    }
	


    	 

    
}
