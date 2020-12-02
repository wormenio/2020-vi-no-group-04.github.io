package modelo;

import modelo.CategorizacionEntidad.CategoriaEntidad;
import modelo.Egreso.Egreso;
import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadBase;
import modelo.Entidades.EntidadJuridica;

import java.util.HashSet;
import java.util.Set;

public class Organizacion {

	private static Organizacion instance = new Organizacion();
	public static Organizacion instance(){
		return instance;
	}

	Set<Entidad> entidades = new HashSet<>();
	Set<EntidadBase> entidadesBase = new HashSet<>();
	Set<EntidadJuridica> entidadesJuridicas = new HashSet<>();
	Set<Egreso> egresos = new HashSet<>();
	Set<CategoriaEntidad> categorias = new HashSet<>();

	private String nombre = "geSoc";

	private Integer cantidadPresupuestosRequeridos =0;

//	public Organizacion(String nombre){
//		this.nombre = nombre;
//	}
//
	public void aregarEntidad(Entidad entidad){
		entidades.add(entidad);
	}

	public void agregaEntidadBase(EntidadBase entidad){
		entidadesBase.add(entidad);
	}

	public void agregarEntidadJuridica(EntidadJuridica entidad){
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

	public void setCantidadPresupuestosRequeridos(Integer cantidad ){
		this.cantidadPresupuestosRequeridos = cantidad;
	}

	public Integer getCantidadPresupuestosRequeridos(){
		return cantidadPresupuestosRequeridos;
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
