package modelo;
import modelo.Egreso.Compra;
import modelo.Egreso.CompraConPresupuesto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ReporteEgreso {
    EtiquetaEgreso etiquetaEgreso;
    RepositorioCompras repoCompras; //Esto que hace aca??

    //FIXME:: agrupado, no filtrado -- google it
    //etiqueta
    //Todos los datos de la etiqueta
   public Map<EtiquetaEgreso, List<Compra>> VerReporteEgreso(EtiquetaEgreso etiqueta){

       List<Compra> compras = Arrays.asList();
       Map<EtiquetaEgreso, List<Compra>> reporteCompras = compras.stream()
               .collect(groupingBy(Compra::getEtiqueta));

       return reporteCompras;
    }
	
	
	
	
}