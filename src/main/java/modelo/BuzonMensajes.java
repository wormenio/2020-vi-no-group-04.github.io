package modelo;
import java.util.ArrayList;
import java.util.List;

//import org.javatuples.*;

public class BuzonMensajes {

	
  //  List<Pair<CompraConPresupuesto,Boolean>> listaDeCompras = new ArrayList<Pair<CompraConPresupuesto,Boolean>>();
   
	
    List<String> listaNotificaciones = new ArrayList<String>();
    RepositorioCompras repositorioCompras;
    
	public BuzonMensajes(RepositorioCompras repositorio) {
		repositorioCompras = repositorio;
	}

    public void enviarNotificaciones() {
    	repositorioCompras.listadoCompras().forEach((compra)->{if(compra.validarCompra()) {
    													compra.usuariosHabilitados().forEach((usuario)->usuario.agregarNotificacion(compra.getId()));
    													}
    	
    													});
    }

/*	public void agregarNotificacion(CompraConPresupuesto compra, Boolean validacion) {
		Pair<CompraConPresupuesto,Boolean> compraValidada = new Pair<CompraConPresupuesto,Boolean>(compra,validacion);
	
		listaDeCompras.add(compraValidada);
		
	}

	

	public List<String> verMensajesDeUsuario(Usuario usuario) {
		
		listaDeCompras.forEach((p)->
		{if(p.getValue0().esRevisor(usuario)) {
			String numeroCompra = String.valueOf(p.getValue0().documentoComercial.numero());
			String valorValidez = String.valueOf(p.getValue1());
			
			listaNotificaciones.add(numeroCompra +' ' +  valorValidez);
			
			
     	 }
		 
		});
		
		return listaNotificaciones;
			
	}*/
	
}
