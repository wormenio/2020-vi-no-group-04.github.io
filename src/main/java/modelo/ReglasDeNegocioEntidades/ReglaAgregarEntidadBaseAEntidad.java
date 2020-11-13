package modelo.ReglasDeNegocioEntidades;


import modelo.Entidades.Entidad;
import modelo.Entidades.EntidadException;
import modelo.Entidades.EntidadJuridica;

class ReglaAgregarEntidadBaseAEntidadJuridica  implements ReglasDeNegocioEntidades {

    Entidad entidad;

    EntidadJuridica entidadJuridicaNoPermitida = null;

    public ReglaAgregarEntidadBaseAEntidadJuridica(EntidadJuridica entidadJuridicaNoPermitida){
        this.entidadJuridicaNoPermitida = entidadJuridicaNoPermitida;
    }


    @Override
    /**
     * No permitir que una entidad base pueda ser parte de alguna entidad jurídica.
     */
    public void aplicarReglaDeNegocioEntidad(Entidad entidad) {
       /* if(entidadJuridicaNoPermitida !=null && entidadJuridicaNoPermitida.equals(entidadJuridica)){
            throw new EntidadException("La categoria no permite que la entidad sea parte la Entidad Juridica indicada");
        }*/
    }

    public void setEntidadAplicaReglas(Entidad entidad) {
        this.entidad = entidad;
    }
}
