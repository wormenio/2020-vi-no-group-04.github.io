package modelo;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainSistema {


public static void main(String[] args) {




		SeleccionadorPais generadorPaies = new SeleccionadorPais();
		List<Pais> paisesSistema = generadorPaies.paisesSistema();
		
		
		RepositorioCompras repositorio = new RepositorioCompras();

		CompraConPresupuesto compraPrimera = new  CompraConPresupuesto();

		repositorio.agregarCompra(compraPrimera);

		BuzonMensajes buzonDeMensajes = new BuzonMensajes(repositorio);
		
		Timer reloj = new Timer();
		TimerTask tarea = new TimerTask(){
	         public void run(){
	     		buzonDeMensajes.enviarNotificaciones();

	         }
	     };
		
	     CompraConPresupuesto compraSegunda = new  CompraConPresupuesto();

	     repositorio.agregarCompra(compraSegunda);

	    reloj.scheduleAtFixedRate(tarea, 0, 1000); 

		

	}

}
