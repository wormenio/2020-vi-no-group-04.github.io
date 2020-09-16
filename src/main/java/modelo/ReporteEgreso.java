package modelo;
import java.util.List;

public class ReporteEgreso {	
    int anio;
    int mes;
    EtiquetaEgreso etiquetaEgreso;
    float monto;
    RepositorioCompras repoCompras;

    //FIXME:: agrupado, no filtrado -- google it
   public List<CompraConPresupuesto> VerReporteEgreso(int mes, int anio, int etiqueta){
     //  .COLLEc.COLLECTORS.T
      return (List<CompraConPresupuesto>)repoCompras.listadoCompras().stream().filter(
              x -> x.getEtiqueta() == etiqueta
              && x.getAnio() == anio 
              && x.getMes() == mes
      );
    }
	
	
	
	
}