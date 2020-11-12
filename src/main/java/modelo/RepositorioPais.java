package modelo;

import modelo.DireccionPostal.Pais;

import java.util.HashSet;
import java.util.Set;

public class RepositorioPais {

    private static RepositorioPais instance = new RepositorioPais();
    public static RepositorioPais instance(){
        return instance;
    }
    Set<Pais> paises = new HashSet<>();

    public Set<Pais> getPaises(){
        return paises;
    }

    public void agregarPais(String nombrePais, Moneda moneda,  String locale){

        Pais pais = new Pais();
        pais.setNombre(nombrePais);
        pais.setMoneda(moneda);
        pais.setLocale(locale);
        paises.add(pais);
        // Persistir en la base
    }
}
