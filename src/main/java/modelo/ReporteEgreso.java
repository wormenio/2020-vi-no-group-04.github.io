package modelo;
import java.util.List;

public class ReporteEgreso {
	
	int anio;
	int mes;
    EtiquetaEgreso etiquetaEgreso;
    float monto;
    RepositorioCompras compras;
    
   List<Compra> VerReporteEgreso(this.etiquetaEgreso){
	   
	   return compras.listadoCompras().stream().filter()
	   
	   
    	
    }
	
	
	
	
}