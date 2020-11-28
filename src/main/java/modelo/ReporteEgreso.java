package modelo;
import modelo.Egreso.Compra;
import modelo.Egreso.Egreso;
import modelo.Egreso.EtiquetaEgreso;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ReporteEgreso {
    EtiquetaEgreso etiquetaEgreso;
    RepositorioCompras repoCompras;

    public Map<EtiquetaEgreso, List<Compra>> VerReporteEgreso(EtiquetaEgreso etiqueta){

        Map<EtiquetaEgreso, List<Compra>> reporteCompras = repoCompras.getCompras()
                .stream()
                .collect(groupingBy(Compra::getEtiquetaEgreso));
//        TODO -> implementar el hash y el equals en Etiqueta egreso
        return reporteCompras;
    }

}