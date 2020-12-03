package modelo;

import modelo.DocumentoComercial.DocumentoComercial;
import modelo.Egreso.Compra;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepositorioDocumentosComerciales implements WithGlobalEntityManager {
    private static RepositorioDocumentosComerciales instance = new RepositorioDocumentosComerciales();
    public static RepositorioDocumentosComerciales instance(){
        return instance;
    }


    Set<DocumentoComercial> documentosComreciales = new HashSet<>();

    public List<DocumentoComercial> listadoDeRegistros(){
        return entityManager()//
                .createQuery("from DocumentoComercial ", DocumentoComercial.class) //
                .getResultList();
    }

}
