package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaAgregarEntidadBaseAEntidadJuridica {
    Entidad entidad;
    public ReglaAgregarEntidadBaseAEntidadJuridica( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer codigo, String descripcion){
        //TODO
        // Esta mal preguntar si la entidad == base
        // deberia de preguntarle a la entidad
        if( entidad.getTipoEntidad() =="BASE"){
            return false;
        }
        return true;
    }
}
