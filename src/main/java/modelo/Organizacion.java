package modelo;

import java.util.ArrayList;

public class Organizacion {
	TipoOrganizacion tipo;
	ArrayList<Organizacion> entidades = new ArrayList<Organizacion>();
	ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
	
	static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();


	public boolean registrarse(String usuario , String contrasenia, RolUsuario rol)
	{
		Usuario nuevoUsuario = new Usuario(usuario,rol);
		if( nuevoUsuario.nombreValido(usuario)  &&  nuevoUsuario.contraseniaValida(contrasenia))
		{
			usuarios.add(nuevoUsuario);
			System.out.println("true");
			return true;
		}else{
			System.out.println("false");
			return false;
		}
		
	}
}
