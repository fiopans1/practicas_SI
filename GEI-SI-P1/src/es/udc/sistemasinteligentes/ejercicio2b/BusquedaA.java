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
        Nodo nodoActual= new Nodo(p.getEstadoInicial(),null,null);
        int i=0;
        Frontera.add(nodoActual);
        Estado S=null;
        Nodo[] H;
        float cn;
        while(!Frontera.isEmpty()){
            nodoActual=Frontera.remove();
            S=nodoActual.getEstado();
            System.out.println((i++) + " - Estado actual cambiado a " + S);
            if(p.esMeta(S)){
                System.out.println((i++) + " - FIN - " + nodoActual.getEstado());
                return Nodo.reconstruyeSolucion(nodoActual);
            }else{
                Explorados.add(S);
                H=Nodo.Sucesores(S,nodoActual,p.acciones(S));
                for(Nodo nh : H){
                    nh.setCoste(nodoActual.getCoste()+1);
                    nh.setFuncion(nh.getCoste()+h.evalua(nh.getEstado()));
                    boolean pertenece=false;
                    if (Explorados.contains(nh.getEstado())) {
                        System.out.println((i++) + " - " + nh.getEstado() + " ya explorado");
                        pertenece = true;
                    }

                    if (!pertenece) {
                        for (Nodo n : Frontera) {
                            if (nh.getEstado().equals(n.getEstado())) {
                                pertenece = true;
                                if(nh.getF()<n.getF()){
                                    System.out.println((i++) + " - Nodo frontera" + n.getEstado() + "actualizado a " + nh.getEstado());
                                    Frontera.remove(n);
                                    Frontera.add(nh);
                                }
                            }
                        }
                    }
                    if (!pertenece) {
                        //System.out.println((i++) + " - " + nh.getEstado() + " NO explorado");
                        Frontera.add(nh);
                    }

                }

            }
        }
        throw new Exception("No se ha podido encontrar una solución");
    }
}
