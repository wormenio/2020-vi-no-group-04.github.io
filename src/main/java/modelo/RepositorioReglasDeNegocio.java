package modelo;

import modelo.ReglasDeNegocio.ReglassDeNegocio;

import java.util.HashSet;
import java.util.Set;

public class RepositorioReglasDeNegocio {
    Set<ReglassDeNegocio> reglasDeNegocios = new HashSet<>();

    public Set<ReglassDeNegocio> getReglasDeNegocios() {
        return reglasDeNegocios;
    }
}
