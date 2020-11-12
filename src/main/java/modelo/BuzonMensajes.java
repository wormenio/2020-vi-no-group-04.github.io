package modelo;

import modelo.Egreso.Compra;
import modelo.Egreso.Egreso;

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
    	compra.usuariosRevisores().forEach((usuario)->{usuario.agregarNotificacion(compra.getId() + compra.estadoValidacion());});
    }

	
}