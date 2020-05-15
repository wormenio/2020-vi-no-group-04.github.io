package modelo;

import java.util.ArrayList;

import java.util.HashMap;

public class Organizacion {
	TipoOrganizacion tipo;
	ArrayList<Organizacion> entidades = new ArrayList<Organizacion>();
	ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
	static ContraseniaSegura contraseniasSeguras = new ContraseniaSegura();
	static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
	static HashMap<String, String> contrasenias = new HashMap<String, String>();


	public void registrarse(String usuario , String contrasenia, RolUsuario rol) {
		if( Organizacion.usuarioValido(usuario,contrasenia)) {
			Usuario nuevoUsuario = new Usuario(usuario,rol);
			usuarios.add(nuevoUsuario);
			contrasenias.put(usuario, contrasenia);
			return;
		}
		System.out.println("fail");
	}
	
	private static boolean usuarioValido(String usuario, String contrasenia) {
		return( Organizacion.nombreValido(usuario) && Organizacion.contraseniaValida(contrasenia));
	}
	
	
	private static boolean contraseniaValida(String contrasenia) {
		return (contraseniasSeguras.esSegura(contrasenia)) ;
	}
	
	private static boolean nombreValido(String usuario) {
		return contrasenias.containsKey(usuario);
			
	}
	
	public void iniciarSesion() {
	
	}
}
