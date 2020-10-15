package modelo;
import java.util.ArrayList;
import java.util.List;

//Nomenclatura revisar - BuzonMensajes
public class BuzonMensajes {

	
 	
    RepositorioCompras repositorioCompras;
    
	public BuzonMensajes(RepositorioCompras repositorio) {
		repositorioCompras = repositorio;
	}

    public void enviarNotificaciones() {
        //FIXME
        //IF COMRA.ESVALIDA() revisar todos los metodos boolean
//		TODO
		/*
    	repositorioCompras.listadoCompras().forEach((compra)->{if(compra.validarCompra()) {
    	compra.usuariosHabilitados().forEach((usuario)->usuario.agregarNotificacion(compra.getId()));
    	}
    	});*/
    }


	
}
