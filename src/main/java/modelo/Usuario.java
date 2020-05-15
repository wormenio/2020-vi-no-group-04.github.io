package modelo;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 public  boolean esValido(String usuario, String contrasenia) {
		return( Usuario.nombreValido(usuario) && contraseniaValida(contrasenia));
	 }
	 
	 private  boolean contraseniaValida(String contrasenia) {
		return contraseniasSeguras.esSegura(contrasenia)
				&& politicasContrasenia(contrasenia);


	 }

	 private boolean politicasContrasenia(String contrasenia){
	 	//Mas de 8 digitos
		 if (contrasenia.length() < 8 ){
			 return false;
			// throw new UsuarioException("La clave debe contenerar mas de 8 caracteres");
		 }
		 // al menos un digito y una clave
		 String regla1 = "^(?:[0-9]+[a-zA-Z]|[a-zA-Z]+[0-9])[a-zA-Z0-9]*$";
		 //No se repitan lo caracteres
		 String regla2 = "([a-zA-Z])\\1{2,}";

		 return validarEr(contrasenia, regla1) && validarEr(contrasenia, regla2);

	 }

	 private boolean validarEr(String palabra, String expresionRegular){
		 Pattern pattern = Pattern.compile(expresionRegular);
		 Matcher matcher =
				 pattern.matcher(palabra);
		 return matcher.matches();

	 }

	 private static boolean nombreValido(String usuario) {
		 return contrasenias.containsKey(usuario);
	 }
	 public static void registrarContrasenia( String usuario, String contrasenia )
	 {
		 contrasenias.put(usuario, contrasenia);
	 }
}
