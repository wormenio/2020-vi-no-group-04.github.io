package modelo;

public class MainSistema {
	public static void main(String[] args) {
		
		RepositorioCompras repositorio = new RepositorioCompras();
		
		CompraConPresupuesto compraPrimera = new  CompraConPresupuesto();

		repositorio.agregarCompra(compraPrimera);
		
		BuzonMensajes buzonDeMensajes = new BuzonMensajes(repositorio);
		
		buzonDeMensajes.enviarNotificaciones();
		
	}

}
