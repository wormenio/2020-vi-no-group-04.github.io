package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Organizacion {
	Set<Entidad> entidades = new HashSet<>();
	Set<EntidadBase> entidadesBase = new HashSet<>();
	Set<EntidadJuridica> entidadesJuridicas = new HashSet<>();
	Set<Compra> egresos = new HashSet<>();
	Set<CategoriaEntidad> categorias = new HashSet<>();


	public void addEntidadBase(EntidadBase entidad){
		entidadesBase.add(entidad);
	}

	public void addEntidadJuridica(EntidadJuridica entidad){
		entidadesJuridicas.add(entidad);
	}
	public Set<Entidad> getEntidades() {
		return entidades;
	}

	public Set<EntidadJuridica> getEntidadesJuridicas(){
		return entidadesJuridicas;
	}

	public Set<EntidadBase> getEntidadesBase(){
		return entidadesBase;
	}

	public Boolean tieneEntidadBase(){
		return entidadesBase.size() > 0;
	}

	public Boolean tieneEntidadJuridica(){
		return entidadesJuridicas.size() > 0;
	}



	//	static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
//
//	public void registrarse(String usuario , String contrasenia, RolUsuario rol)
//	{
//		Usuario nuevoUsuario = new Usuario();
//
//		nuevoUsuario.registrarUsuario(usuario,rol, contrasenia);
//	}
}
