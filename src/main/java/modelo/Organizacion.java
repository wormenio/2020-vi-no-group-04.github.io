package modelo;

import java.util.ArrayList;

public class Organizacion {
	TipoOrganizacion tipo;
	ArrayList<Organizacion> entidades = new ArrayList<Organizacion>();
	ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
	
	static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();


	public void registrarse(String usuario , String contrasenia, RolUsuario rol) {
		Usuario nuevoUsuario = new Usuario(usuario,rol);
		if( nuevoUsuario.esValido(usuario,contrasenia))
		{
			usuarios.add(nuevoUsuario);
			return;
		}else {
			System.out.println("fail");
		}
		
	}
	
	public void iniciarSesion() {
	
	}
}
