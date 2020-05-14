package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Organizacion {
	TipoOrganizacion tipo;
	ArrayList<Organizacion> entidades = new ArrayList<Organizacion>();
	static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
	static HashMap<String, String> contrasenias = new HashMap<String, String>();


	public void registrarse(String usuario , String contrasenia, RolUsuario rol) {
		Usuario nuevoUsuario = new Usuario(usuario,rol);
		if( Organizacion.chequearUsuario(usuario,contrasenia)) {
			usuarios.add(nuevoUsuario);
			contrasenias.put(usuario, contrasenia);
		}
		System.out.println("fail");
	}
	
	private static boolean chequearUsuario(String usuario, String contrasenia) {
		return( Organizacion.nombreValido(usuario) && Organizacion.contraseniaValida(contrasenia));
	}
	
	
	private static boolean contraseniaValida(String contrasenia) {
		return true;
	}
	
	private static boolean nombreValido(String usuario) {
		return contrasenias.containsKey(usuario);
			
	}
	
	public void iniciarSesion() {
	
	}
}
