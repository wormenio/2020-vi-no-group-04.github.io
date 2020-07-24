package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaAgregarEntidadBaseAEntidadJuridica {
    Entidad entidad;
    public ReglaAgregarEntidadBaseAEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer codigo, String descripcion){
        if( entidad.getTipoEntidad() =="BASE"){
            return false;
        }
        return true;
    }
}
