package modelo;
import java.util.ArrayList;
import java.util.List;


public class BuzonMensajes {

	
 	
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


	
}
