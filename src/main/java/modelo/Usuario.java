package modelo;

import modelo.ValidarContrasenia.*;
import modelo.UsuarioException;
import java.util.ArrayList;
import java.util.List;


public class Usuario{
    Boolean is_Admin;
	String nombreUsuario;
    List<String> notificacionCompras = new ArrayList<String>();

	public Usuario(String nombreUsuario, Boolean isAdmin, String contrasenia){
			validarContrasenia(contrasenia);
			registrarContrasenia(contrasenia);
			this.nombreUsuario = nombreUsuario;
			this.is_Admin = isAdmin;
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
/*
	private void verificarSiExisteUsuario(String usuario) {
		 if (listaUsuarios.contains(usuario)) {
		 //	System.out.println("no se");
		 	throw new UsuarioException("El usuario "+usuario+" ya existe en el sistema");
		 }
	}

	private void registrarUsuario(String nombreUsuario){
		 listaUsuarios.add(nombreUsuario);
	 }

 */
	private void registrarContrasenia(String contrasenia){
		//TODO
	}
    
/*	public List<String> verBuzonDeMensajes() {
		
		return	buzonDeMensajes.verMensajesDeUsuario(this);
	
	}*/

}


