package modelo;
import modelo.CategoriaEntidad.CategoriaEntidad;
import modelo.Egreso.*;
import org.scalactic.Or;

import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainSistema {
	private Moneda pesoArgentino = new Moneda("PesoArgentino");
	Pais argentina = new Pais("Argentina", "Pesos", "1", "Es-ar");
	private Organizacion geSoc = new Organizacion("Gesoc");

	public  void main(String[] args) {


		SeleccionadorPais generadorPaies = new SeleccionadorPais();
		List<Pais> paisesSistema = generadorPaies.paisesSistema();


		RepositorioCompras repositorio = new RepositorioCompras();
		CompraConPresupuesto compraPrimera = compraConPresupuesto(LocalDate.now());
		repositorio.agregarCompraConPresupuesto(compraPrimera);

		
		BuzonMensajes buzonDeMensajes = new BuzonMensajes(repositorio);

		this.correrValidacionDeCompras(repositorio, buzonDeMensajes);
		this.tareaProgramadaEgresos(this, repositorio, buzonDeMensajes);
		/*Timer reloj = new Timer();
		TimerTask tarea = new TimerTask(){
			 public void run(){
				 correrValidacionDeCompras(repositorio,buzonDeMensajes);
				

			 }

		 };*/

		 CompraConPresupuesto compraSegunda = compraConPresupuesto(LocalDate.now());

		 repositorio.agregarCompraConPresupuesto(compraSegunda);

		//reloj.scheduleAtFixedRate(tarea, 0, 1000);

	}

	private CompraConPresupuesto compraConPresupuesto (LocalDate fecha){
		return  new CompraConPresupuesto(
				fecha,
				proveedorOfimatica(),
				pesoArgentino,
				unaEntidadBase(),
				new EtiquetaEgreso("Utiles")
		);
	}
	public void tareaProgramadaEgresos(MainSistema mainSistema,RepositorioCompras repositorio, BuzonMensajes buzonDeMensajes) {
		 Timer reloj = new Timer();
		 TimerTask tarea = new TimerTask(){
			 public void run(){
				 mainSistema.correrValidacionDeCompras(repositorio,buzonDeMensajes);
				

			 }

		 };
		reloj.scheduleAtFixedRate(tarea, 0, 1000);

	}
	public void correrValidacionDeCompras( RepositorioCompras repositorio, BuzonMensajes buzonDeMensajes){
		repositorio.validarCompras();
		buzonDeMensajes.enviarNotificaciones();
	}

	Proveedor proveedorOfimatica(){
		DireccionPostal direccionPostalMozart = new DireccionPostal(argentina,"mozart","215","1");
		return new Proveedor("Juan",
				"Perez",
				"Ofimatica",
				"25858685",
				"25858568585",
				direccionPostalMozart,
				"1",
				"1");
	}

	Entidad unaEntidadBase(){
		return new EntidadBase("La Comercial","Venta de Ropas",
				new CategoriaEntidad(2585),
				geSoc);
	}

	Item unItem(String nombre){
		return new Item(nombre );
	}




}
