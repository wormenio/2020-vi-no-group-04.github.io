package modelo;

import java.util.HashMap;

public class Usuario{
	 RolUsuario rol;
	 String nombre;
	 static ContraseniaSegura contraseniasSeguras = new ContraseniaSegura();
	 static HashMap<String, String> contrasenias = new HashMap<String, String>();
	 
	 public String nombre() {
		 return nombre;
	 }
	 public Usuario(String nuevoNombre, RolUsuario nuevoRol){
		 nombre = nuevoNombre;
         rol = nuevoRol;
     }
	 public static boolean esValido(String usuario, String contrasenia) {
		return( Usuario.nombreValido(usuario) && Usuario.contraseniaValida(contrasenia));
	 }
	 
	 private static boolean contraseniaValida(String contrasenia) {
		 return (contraseniasSeguras.esSegura(contrasenia)) ;
	 }
	 private static boolean nombreValido(String usuario) {
		 return contrasenias.containsKey(usuario);
	 }
	 public static void registrarContrasenia( String usuario, String contrasenia )
	 {
		 contrasenias.put(usuario, contrasenia);
	 }
}
