package modelo;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepositorioUsuarios implements WithGlobalEntityManager {

	private static RepositorioUsuarios instance = new RepositorioUsuarios();
	public static RepositorioUsuarios instance(){
		return instance;
	}
	public void validarUsuario(String usuario, String password) {
		
	}
}
