package es.udc.sistemasinteligentes.apartado2a;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.Nodo;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

import java.util.ArrayList;

public class EstrategiaAmplitud implements EstrategiaBusqueda {
    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception {
        ArrayList<Nodo> Frontera= new ArrayList<>();//se utilizará como una cola FIFO
        ArrayList<Nodo> Explorados= new ArrayList<>();
        Nodo nodoActual= new Nodo(p.getEstadoInicial(),null,null);
        Nodo[] H;
        int i=1;
        Frontera.add(nodoActual);
        while(!Frontera.isEmpty()){
            nodoActual=Frontera.get(0);
            Frontera.remove(0);
            System.out.println((i++) + " - Estado actual cambiado a " + nodoActual.getEstado());
            Explorados.add(nodoActual);
            H = Nodo.Sucesores(nodoActual.getEstado(), nodoActual, p.acciones(nodoActual.getEstado()));
            for (Nodo h : H) {//añadimos cada uno de los sucesores a la solucion
                boolean pertenece = false;
                if(p.esMeta(h.getEstado())){
                    System.out.println((i++) + " - FIN - " + h.getEstado());
                    return Nodo.reconstruyeSolucion(h);
                }else {
                    System.out.println((i++) + " - " + nodoActual.getEstado() + " no es meta");
                    for (Nodo n : Explorados) {
                        if (h.getEstado().equals(n.getEstado())) {
                            System.out.println((i++) + " - " + h.getEstado() + " ya explorado");
                            pertenece = true;
                        }
                    }
                    if (!pertenece) {
                        for (Nodo n : Frontera) {
                            if (h.getEstado().equals(n.getEstado())) {
                                pertenece = true;
                            }
                        }
                    }
                    if (!pertenece) {
                        System.out.println((i++) + " - " + h.getEstado() + " NO explorado");
                        Frontera.add(h);
                    }
                }
            }
        }

        throw new Exception("No se ha podido encontrar una solución");
    }
}
