package modelo;

import modelo.ReglasDeNegocio.ReglaDeNegocio;

import java.util.HashSet;
import java.util.Set;

public class RepositorioReglasDeNegocio {
    Set<ReglaDeNegocio> reglasDeNegocios = new HashSet<>();

    public Set<ReglaDeNegocio> getReglasDeNegocios() {
        return reglasDeNegocios;
    }
}
