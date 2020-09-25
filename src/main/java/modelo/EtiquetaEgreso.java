package modelo;

import dao.EtiquetaDao;
import entities.EtiquetaEntity;

import java.util.List;
import java.util.Map;

public class EtiquetaEgreso {

//	List<EtiquetaEntity> etiquetas ;
	EtiquetaDao etiquetaDao = new EtiquetaDao();

	public void AgregarEtiqueta( String nombre) {
		etiquetaDao.create(nombre);
	}
        
	public void EliminarEtiqueta(String nombre) {
		etiquetaDao.delete(nombre);
	}


	public String getEtiquetas(){
		//TODO
		return "etiqueta";
	}
}


