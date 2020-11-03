package modelo;
import java.util.ArrayList;
import java.util.List;

import modelo.Egreso.Compra;

//Nomenclatura revisar - BuzonMensajes
public class BuzonMensajes {

	
 	
    RepositorioCompras repositorioCompras;
    
	public BuzonMensajes(RepositorioCompras repositorio) {
		repositorioCompras = repositorio;
	}

    public void enviarNotificaciones() {
       
    	repositorioCompras.getComprasConPresupuesto().forEach((compra)->{this.notificarUsuarios(compra);});
    }

    public void notificarUsuarios(Compra compra) {
    	compra.usuariosHabilitados().forEach((usuario)->{usuario.agregarNotificacion(compra.getId() + compra.estadoValidacion());});
    }

	
}