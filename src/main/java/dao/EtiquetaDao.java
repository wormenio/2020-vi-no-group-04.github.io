package dao;


import entities.EtiquetaEntity;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

public class EtiquetaDao extends AbstractPersistenceTest implements WithGlobalEntityManager {

    EtiquetaEntity entity = new EtiquetaEntity();

    public void create(String nombre) {
        entity.setNombre(nombre);

        try{
            entityManager().persist(entity);
        }
        catch (Exception e){
            System.out.println("No se puede persistir el registro, motivo: "+e.getMessage());
        }

    }

    public void getRegistros(){

    }

    public void delete(String nombre){

    }


}
