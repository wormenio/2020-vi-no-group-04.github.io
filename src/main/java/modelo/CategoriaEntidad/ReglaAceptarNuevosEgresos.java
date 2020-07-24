package modelo.CategoriaEntidad;


import modelo.Entidad;

class ReglaAceptarNuevosEgresos {
    Entidad entidad;
    public ReglaAceptarNuevosEgresos( Entidad entidad){
        this.entidad = entidad;
    }

    boolean aplicarRegla(Integer monto_compra, Entidad entidad){
        return entidad.getMontoMaximoEgreso() > monto_compra;
    }
}
