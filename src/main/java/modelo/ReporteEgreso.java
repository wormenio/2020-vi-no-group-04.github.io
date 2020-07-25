package modelo;
import java.util.List;
import java.util.stream.Collectors;

public class ReporteEgreso {	
    int anio;
    int mes;
    EtiquetaEgreso etiquetaEgreso;
    float monto;
    RepositorioCompras repoCompras;
    
    //FIXME:: agrupado, no filtrado -- google it
   public List<CompraConPresupuesto> VerReporteEgreso(int mes, int anio, int etiqueta){            
      return repoCompras.listadoCompras().stream().filter(
              x -> x.getEtiqueta() == etiqueta 
              && x.getAnio() == anio 
              && x.getMes() == mes
      ).collect(Collectors.toList()) ;
    }
	
	
	
	
}