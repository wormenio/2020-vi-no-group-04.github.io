package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaBloquearEntidadBaseEnEntidadJuridica {
    Entidad entidad;
    public ReglaBloquearEntidadBaseEnEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }
    boolean aplicarRegla(){
        if( entidad.getTipoEntidad() == "ENTIDADJURIDICA"){
            return false;
        }
        return true;
    }
}
