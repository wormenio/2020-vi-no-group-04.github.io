package modelo;

import modelo.ValidarContrasenia.*;
import modelo.UsuarioException;
import java.util.ArrayList;


public class Usuario{
    RolUsuario rolUsuario;
	String nombreUsuario;
	ArrayList<String> listaUsuarios = new ArrayList<String>();

	public void registrarUsuario(String nombreUsuario, RolUsuario rolUsuario, String contrasenia){
	 	try {
			verificarSiExisteUsuario(nombreUsuario);
			validarContrasenia(contrasenia);
			registrarUsuario(nombreUsuario);
			registrarContrasenia(contrasenia);
			this.nombreUsuario = nombreUsuario;
			this.rolUsuario = rolUsuario;
		}
	 	catch (Exception e){
			System.out.println("No se puede crear el Usuario, motivo: "+e.getMessage());
		}

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public  void validarContrasenia(String contrasenia) {
	 	ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();

		ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();
		ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
		ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
		ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();

		listValidarContrasenia.add(validarLongitudMinima);
		//listValidarContrasenia.add(validarCaracteresRepetidos);
		//listValidarContrasenia.add(validarUnNumeroUnaLetra);
		//listValidarContrasenia.add(validarContraseniaDebil);

		//validarLongitudMinima.validar(contrasenia);
		listValidarContrasenia.forEach( objeto -> objeto.validar(contrasenia) );

	}


	private void verificarSiExisteUsuario(String usuario) {
		 if (listaUsuarios.contains(usuario)) {
		 //	System.out.println("no se");
		 	throw new UsuarioException("El usuario "+usuario+" ya existe en el sistema");
		 }
	}

	private void registrarUsuario(String nombreUsuario){
		 listaUsuarios.add(nombreUsuario);
	 }

	private void registrarContrasenia(String contrasenia){
	 	//TODO
	}

}


