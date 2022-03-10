package es.udc.sistemasinteligentes.ejercicio2b;

import es.udc.sistemasinteligentes.Estado;
import es.udc.sistemasinteligentes.Heuristica;
import es.udc.sistemasinteligentes.apartado2a.ProblemaCuadradoMagico.*;

public class HeuristicaCuadradoMagico extends Heuristica {//mañana buscar una que sea decente
    @Override
    public float evalua(Estado e) {
        int x=0,y=0;
        boolean encontrado=false;
        EstadoCuadrado es= (EstadoCuadrado) e;
        for(int i=0;i<es.getEstado().length;i++){
            for(int j=0;j<es.getEstado().length;j++){
                if(es.getEstado()[i][j]==0){
                    encontrado=true;
                    break;
                }else {
                    x = i;
                    y = j;
                }
            }
            if(encontrado){
                break;
            }
        }

        return (Math.abs((es.getEstado().length-x))+ Math.abs((es.getEstado().length-y)));
    }
}
