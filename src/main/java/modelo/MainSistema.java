package modelo;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.Egreso.Compras;
import modelo.Egreso.Item;
import modelo.MedioDePago.TarjetaDeCredito;

import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainSistema {


public static void main(String[] args) {


	SeleccionadorPais generadorPaies = new SeleccionadorPais();
	List<Pais> paisesSistema = generadorPaies.paisesSistema();

		
	RepositorioCompras repositorio = new RepositorioCompras();

		CompraConPresupuesto compraPrimera = new CompraConPresupuesto();

		repositorio.agregarCompraConPresupuesto(compraPrimera);

		BuzonMensajes buzonDeMensajes = new BuzonMensajes(repositorio);
		
		Timer reloj = new Timer();
		TimerTask tarea = new TimerTask(){
	         public void run(){
	     		buzonDeMensajes.enviarNotificaciones();

	         }
	     };
		
	     CompraConPresupuesto compraSegunda = new  CompraConPresupuesto();

	     repositorio.agregarCompraConPresupuesto(compraSegunda);

	    reloj.scheduleAtFixedRate(tarea, 0, 1000); 

		

	}

}
