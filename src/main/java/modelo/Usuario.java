package modelo;

import modelo.ValidarContrasenia.*;
import modelo.UsuarioException;
import java.util.ArrayList;
import java.util.List;


public class Usuario{
    RolUsuario rolUsuario;
	String nombreUsuario;
    List<String> notificacionCompras = new ArrayList<String>();
	//ArrayList<String> listaUsuarios = new ArrayList<String>();
	//BuzonMensajes buzonDeMensajes;

	public Usuario(String nombreUsuario, RolUsuario rolUsuario, String contrasenia){
		try {
			//verificarSiExisteUsuario(nombreUsuario);
			validarContrasenia(contrasenia);
		//	registrarUsuario(nombreUsuario);
			registrarContrasenia(contrasenia);
			this.nombreUsuario = nombreUsuario;
			this.rolUsuario = rolUsuario;
		}
		catch (Exception e){
			System.out.println("No se puede crear el Usuario, motivo: "+e.getMessage());
		}
	}

	
/*
	public Usuario(BuzonMensajes buzon) {
		buzonDeMensajes = buzon;
	}

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
*/

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


