package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaBloquearEntidadBaseEnEntidadJuridica {
    Entidad entidad;
    public ReglaBloquearEntidadBaseEnEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }
    boolean aplicarRegla(){
//        return  entidad.getTipoEntidad() != "ENTIDADJURIDICA"

        if( entidad.getTipoEntidad() == "ENTIDADJURIDICA"){
            return false;
        }
        return true;
    }
}
