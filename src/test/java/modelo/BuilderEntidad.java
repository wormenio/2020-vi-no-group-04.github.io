package modelo;

import modelo.CategoriaEntidad.CategoriaEntidad;

public class BuilderEntidad {
    private String nombreFicticio;
    private String descripcion;
    private CategoriaEntidad categoriaEntidad;
    private Organizacion geSoc = new Organizacion("Gesoc");
    private String razonSocial;
    private DireccionPostal direccionPostal;
    private CategoriaEntidadJuridica categoriaEntidadJuridica;
    private String cuit;

    public BuilderEntidad setNombreFicticio(String nombreFicticio){
        this.nombreFicticio = nombreFicticio;
        return this;
    }
    
    public BuilderEntidad setDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }
    
    public BuilderEntidad setCategoriaEntidad(CategoriaEntidad categoriaEntidad){
        this.categoriaEntidad = categoriaEntidad;
        return this;
    }
    
    public BuilderEntidad setRazonSocial(String razonSocial){
        this.razonSocial = razonSocial;
        return this;
    }
    
    public BuilderEntidad setDireccionPostal(DireccionPostal direccionPostal){
        this.direccionPostal = direccionPostal;
        return this;
    }
    
    public BuilderEntidad setCuit(String cuit){
        this.cuit = cuit;
        return this;
    }

    public BuilderEntidad setCategoriaEntidadJuridica(CategoriaEntidadJuridica categoriaEntidadJuridica){
        this.categoriaEntidadJuridica = categoriaEntidadJuridica;
        return this;
    }
    
    public EntidadBase crearEntidadBase(){
        return new EntidadBase(nombreFicticio,descripcion,categoriaEntidad,geSoc);
    }
    
    public EntidadJuridica crearEntidadJuridica(){
 
        return  new EntidadJuridica(razonSocial,nombreFicticio,cuit,direccionPostal,categoriaEntidadJuridica,geSoc);
    }
}
