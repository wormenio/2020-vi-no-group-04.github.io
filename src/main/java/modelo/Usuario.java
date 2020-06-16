package modelo;

import modelo.ValidarContrasenia.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Usuario{
	 RolUsuario rol;
	 String nombre;
	 ArrayList<ValidarContrasenia> validarContraseniaList = new ArrayList<ValidarContrasenia>();


	// static ValidarContraseniaDebil contraseniasSeguras = new ValidarContraseniaDebil();
	static HashMap<String, String> contrasenias = new HashMap<String, String>();
	 
	 public String nombre() {
		 return nombre;
	 }

	 public Usuario(String nuevoNombre, RolUsuario nuevoRol){
		 nombre = nuevoNombre;
         rol = nuevoRol;
     }




	 public  void contraseniaValida(String contrasenia) {
	 	try {
			ValidarLongitudMinima validarLongitudMinima = new ValidarLongitudMinima();
			ValidarCaracteresRepetidos validarCaracteresRepetidos = new ValidarCaracteresRepetidos();
			ValidarUnDigitoUnaClave validarUnDigitoUnaClave = new ValidarUnDigitoUnaClave();
			ValidarContraseniaDebil validarCntraseniaDebil = new ValidarContraseniaDebil();

			ArrayList<ValidarContrasenia> listValidarContrasenia = new ArrayList<ValidarContrasenia>();

			listValidarContrasenia.add(validarLongitudMinima);
			listValidarContrasenia.add(validarCaracteresRepetidos);
			listValidarContrasenia.add(validarUnDigitoUnaClave);
			listValidarContrasenia.add(validarCntraseniaDebil);

			listValidarContrasenia.forEach( objeto -> objeto.validar(contrasenia) );

		}
	 	catch (Exception e){
			System.out.println(e.getMessage());
		}

	 }


	 public boolean nombreValido(String usuario) {
		 
		 return contrasenias.containsKey(usuario);
	 }
	 public static void registrarContrasenia( String usuario, String contrasenia )
	 {
		 contrasenias.put(usuario, contrasenia);
	 }
}
