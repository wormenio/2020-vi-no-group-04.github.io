package modelo;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;



public class  APIMlibre {
	private ClientResponse cliente;

	
	public APIMlibre() {
        this.setearCliente(Client.create()
            .resource("https://api.mercadolibre.com/")
           .path("classified_locations/countries")
           .accept(MediaType.APPLICATION_JSON)
           .get(ClientResponse.class));
    }
	public ClientResponse verCliente() {
		return cliente;
	}
	public void setearCliente(ClientResponse cliente) {
		this.cliente = cliente;
	}
	
	public String pepe() {
		return cliente.getEntity(String.class);
	}
	
	


	
}
