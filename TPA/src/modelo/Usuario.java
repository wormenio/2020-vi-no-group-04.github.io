package modelo;

public class Usuario{
	 RolUsuario rol;
	 String nombre;
	 public String nombre() {
		 return nombre;
	 }
	 public Usuario(String nuevoNombre, RolUsuario nuevoRol){
		 nombre = nuevoNombre;
         rol = nuevoRol;
     }
	 
	

}
