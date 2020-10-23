package modelo;

import modelo.ValidarContrasenia.*;
import modelo.UsuarioException;
import java.util.ArrayList;
import java.util.List;


public class Usuario{
    Boolean is_Admin;
	String nombreUsuario;
    List<String> notificacionCompras = new ArrayList<String>();
    RolUsuario rolUsuario;

	public Usuario(String nombreUsuario, RolUsuario rolUsuario, String contrasenia){
			validarContrasenia(contrasenia);
			registrarContrasenia(contrasenia);
			this.nombreUsuario = nombreUsuario;
			this.rolUsuario = rolUsuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void validarContrasenia(String contrasenia) {
	 	ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();

		ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();
		ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
		ValidarUnNumeroUnaLetra validarUnNumeroUnaLetra = new ValidarUnNumeroUnaLetra();
		ValidarContraseniaDebil validarContraseniaDebil = new ValidarContraseniaDebil();
		
		// Usar Arrays.asList
		listValidarContrasenia.add(validarLongitudMinima);
		listValidarContrasenia.add(validarCaracteresRepetidos);
		listValidarContrasenia.add(validarUnNumeroUnaLetra);
		listValidarContrasenia.add(validarContraseniaDebil);

		listValidarContrasenia.forEach( objeto -> objeto.validar(contrasenia) );

	}

	public void agregarNotificacion(String idCompra) {
		notificacionCompras.add(idCompra);
	}

	private void registrarContrasenia(String contrasenia){
		//TODO
	}
    


}


