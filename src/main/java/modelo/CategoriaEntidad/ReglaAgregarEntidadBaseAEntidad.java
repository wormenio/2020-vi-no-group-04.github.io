package modelo.CategoriaEntidad;


import modelo.Entidades.Entidad;

class ReglaAgregarEntidadBaseAEntidadJuridica {
    Entidad entidad;
    public ReglaAgregarEntidadBaseAEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer codigo, String descripcion){

        if( entidad.esEntidadBase() ){
            return false;
        }
        return true;
    }
}
