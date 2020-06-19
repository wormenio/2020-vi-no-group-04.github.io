package modelo;

public class MainSistema {
	public static void main(String[] args) {
		BuzonMensajes buzonDeMensajes = new BuzonMensajes();
		CompraConPresupuesto compraPrimera = new  CompraConPresupuesto(buzonDeMensajes);
		Usuario usuarioPrimero = new Usuario(buzonDeMensajes);
		
		Boolean validacion = compraPrimera.validarCompra();
		
		usuarioPrimero.verBuzonDeMensajes();
	}

}
