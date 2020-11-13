package modelo.ReglasDeNegocioEntidades;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;
import modelo.ReglasDeNegocioEntidades.ReglasDeNegocioEntidades;

class ReglaBloquearEntidadBaseEnEntidadJuridica implements ReglasDeNegocioEntidades {

    @Override
    /**
     * Bloquear la posibilidad de agregar entidades base a una entidad jurídica.
     */
    public void aplicarReglaDeNegocioEntidad(Entidad entidad) {
        if( entidad.esEntidadJuridica() ){
            throw new EntidadException("La categoria no permite que pueda agregar una nueva entidad base");
        }
    }
}
