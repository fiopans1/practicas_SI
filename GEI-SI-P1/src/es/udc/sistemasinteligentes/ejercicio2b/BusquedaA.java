package es.udc.sistemasinteligentes.ejercicio2b;

import es.udc.sistemasinteligentes.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BusquedaA implements EstrategiaBusquedaInformada {
    @Override
    public Nodo[] soluciona(ProblemaBusqueda p, Heuristica h) throws Exception {
        PriorityQueue<Nodo> Frontera= new PriorityQueue<>();
        ArrayList<Estado> Explorados= new ArrayList<>();
        Nodo nodoActual= new Nodo(p.getEstadoInicial(),null,null, 0);
        Frontera.add(nodoActual);
        Estado S=null;
        Nodo[] H;
        float cn;
        while(!Frontera.isEmpty()){
            nodoActual=Frontera.peek();
            S=nodoActual.getEstado();
            if(p.esMeta(S)){
                return Nodo.reconstruyeSolucion(nodoActual);
            }else{
                Explorados.add(S);
                H=Nodo.Sucesores(S,nodoActual,p.acciones(S));
                for(Nodo nh : H){
                    cn=
                }

            }
        }
    }
}
