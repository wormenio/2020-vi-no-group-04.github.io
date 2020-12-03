package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import modelo.Egreso.Compra;

public class RepositorioUsuarios implements WithGlobalEntityManager {

	private static RepositorioUsuarios instance = new RepositorioUsuarios();
	public static RepositorioUsuarios instance(){
		return instance;
	}
	public Usuario validarUsuario(String usuario, String password) {
		if(usuarios.get(password).getNombreUsuario() == usuario) {
			return entityManager()
					.createQuery("from Usuario ", Usuario.class) //
					.getSingleResult();
		}
		return null;
		
	}
	
	HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	
}
