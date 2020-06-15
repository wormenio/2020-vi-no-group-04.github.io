package modelo;


import java.util.ArrayList;
import java.util.List;

public class Compra implements ReferenciaEgreso {
	 Proveedor proveedor;
	 List<Presupuesto> presupuestos;
	 List<Usuario> usuariosHabilitados;
	 List<Item> items = new ArrayList<Item> ();
	 
	 public boolean usuarioHabilitado(Usuario usuario) {
		 return true;
	 }
	 
	 public void habilitarUsuario(Usuario usuario) {
		 this.usuariosHabilitados.add(usuario);
	 }
	 public int  calcularMonto() {
		return 0;
		 
	 }

}
