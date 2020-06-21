package modelo;

public enum CategorizacionAFIP {
	MICRO,PEQUENIA,MEDIANA_TRAMO_1,MEDIANA_TRAMO_2;
        
    public CategorizacionAFIP getCategorizacionAFIP(int cantidadEmpleados){
        CategorizacionAFIP categoria = 
                (cantidadEmpleados >= 5 && cantidadEmpleados <= 15) ? CategorizacionAFIP.MICRO :
                (cantidadEmpleados > 15 && cantidadEmpleados <= 60) ? CategorizacionAFIP.PEQUENIA :
                (cantidadEmpleados > 60 && cantidadEmpleados <= 235) ? CategorizacionAFIP.MEDIANA_TRAMO_1 :
                 CategorizacionAFIP.MEDIANA_TRAMO_2;
        return categoria;
    }
}
