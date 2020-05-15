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


/* desacoplamos las validaciones de usuario y contrasenia
	 public  boolean esValido(String usuario, String contrasenia) {
		return( nombreValido(usuario) && contraseniaValida(contrasenia));
	 }
*/
	 public  boolean contraseniaValida(String contrasenia) {
		return contraseniasSeguras.esSegura(contrasenia)
				&& politicasContrasenia(contrasenia);
	 }

	/**
	 * Se definen las reglas de negocio que se aplican a la estructura que debe tener la constrasenia
	 * @param contrasenia
	 * @return
	 * @throws UsuarioException
	 */
	 public boolean politicasContrasenia(String contrasenia) throws UsuarioException {
//		 return true;
	 	//Mas de 8 digitos
		 if (contrasenia.length() < 8 ){
			 throw new UsuarioException("La clave debe contenerar mas de 8 caracteres");
		 }
		 // Al menos un digito y una clave
		 String regla1 = "^(?:[0-9]+[a-zA-Z]|[a-zA-Z]+[0-9])[a-zA-Z0-9]*$";
		 //No se repitan lo caracteres
		 String regla2 = "([a-zA-Z0-9])\1{2,}";
		 if( !validarEr(contrasenia,regla1) ){
			 throw new UsuarioException("La clave debe tener al menos un número y una letra");
		 }
		 
		 if( validarEr(contrasenia,regla2) ){
			 // System.out.println("regla2 fail");
			 throw new UsuarioException("La clave: "+contrasenia+" no debe repetir tres letras de forma consecutiva, ejemplo aaa");
		 }
		 return true;

	 }

	/**
	 * Valida si se aplica la expresionRegular en la palabra
	 * @param palabra
	 * @param expresionRegular
	 * @return
	 */
	 private boolean validarEr(String palabra, String expresionRegular){
		 Pattern pattern = Pattern.compile(expresionRegular);
		 Matcher matcher =
				 pattern.matcher(palabra);
		 return matcher.matches();

	 }

	 public boolean nombreValido(String usuario) {
		 
		 return contrasenias.containsKey(usuario);
	 }
	 public static void registrarContrasenia( String usuario, String contrasenia )
	 {
		 contrasenias.put(usuario, contrasenia);
	 }
}
