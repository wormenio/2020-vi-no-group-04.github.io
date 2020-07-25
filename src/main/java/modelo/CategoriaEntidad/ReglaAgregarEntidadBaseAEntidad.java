package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaAgregarEntidadBaseAEntidadJuridica {
    Entidad entidad;
    public ReglaAgregarEntidadBaseAEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer codigo, String descripcion){
        return entidad.getTipoEntidad().equals("BASE");
    }
}