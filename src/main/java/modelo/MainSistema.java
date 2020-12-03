package modelo;
import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.DireccionPostal.DireccionPostal;
import modelo.DireccionPostal.Pais;
import modelo.Egreso.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadBase;


public class MainSistema {

	private Moneda pesoArgentino;
	public Organizacion gesoc = new Organizacion();

	/*

	Pais argentina = new Pais("Argentina", "ARS", "AR", "es_AR");
	Provincia capital_federal = new Provincia("Capital Federal","TUxBQ0NBUGZlZG1sYQ");
	Ciudad villa_luro = new Ciudad("Villa Luro", "TUxBQlZJTDI3MDJa");
	private Organizacion geSoc = new Organizacion("Gesoc");
*/
	public  void main(String[] args) {


		SeleccionadorPais generadorPaies = new SeleccionadorPais();
		List<Pais> paisesSistema = generadorPaies.paisesSistema();


		RepositorioCompras repositorio = new RepositorioCompras();
		Compra compraPrimera = compraConPresupuesto(LocalDate.now());
		repositorio.agregarCompra(compraPrimera);


		BuzonMensajes buzonDeMensajes = new BuzonMensajes(repositorio);

		this.correrValidacionDeCompras(repositorio, buzonDeMensajes);
		this.tareaProgramadaEgresos(this, repositorio, buzonDeMensajes);
		/*Timer reloj = new Timer();
		TimerTask tarea = new TimerTask(){
			 public void run(){
				 correrValidacionDeCompras(repositorio,buzonDeMensajes);


			 }

		 };*/

		 Compra compraSegunda = compraConPresupuesto(LocalDate.now());

		 repositorio.agregarCompra(compraSegunda);

		//reloj.scheduleAtFixedRate(tarea, 0, 1000);

	}



	private Moneda pesoArgentino(){
		Moneda pesoArgentino = new Moneda();
		pesoArgentino.setNombre("Peso Argentino");
		return pesoArgentino;
	}

	private Compra compraConPresupuesto (LocalDate fecha){
//		Moneda pesoArgentino = pesoArgentino();
//		EtiquetaEgreso etiqueta = new EtiquetaEgreso();
		Compra compra = new Compra();
		compra.setRequierePresupuesto(true);
		return compra;
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
		DireccionPostal direccionPostalMozart = new DireccionPostal();
		return new Proveedor();
	}

	Entidad unaEntidadBase(){
		return new EntidadBase("La Comercial","Venta de Ropas",
				new CategoriaEntidad() );
	}

	Item unItem(){
		return new Item( );
	}




}
