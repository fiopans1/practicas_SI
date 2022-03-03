package es.udc.sistemasinteligentes;

import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

import java.util.ArrayList;
import java.util.Objects;

public class Nodo {
    private final Estado estado;
    private final Accion accion;
    private final Nodo padre;
    public Nodo(Estado e, Nodo p, Accion a){
        this.estado=e;
        this.padre=p;
        this.accion=a;


    }
    public static Nodo[] Sucesores(Estado e,Nodo p, Accion[] accionesDisponibles){
        ArrayList<Nodo> sucesores= new ArrayList<Nodo>();
        for(Accion acc: accionesDisponibles){
            sucesores.add(new Nodo(acc.aplicaA(e),p,acc));
        }
        Nodo[] arraysolucion= new Nodo[sucesores.size()];
        sucesores.toArray(arraysolucion);
        return arraysolucion;
    }

    public Accion getAccion() {
        return accion;
    }

    public Estado getEstado() {
        return estado;
    }

    public Nodo getPadre() {
        return padre;
    }
    public static Nodo[] reconstruyeSolucion(Nodo n){
        ArrayList<Nodo> solucion = new ArrayList<Nodo>();
        Nodo nodoactual= n;
        while (nodoactual!=null){
            solucion.add(nodoactual);
            nodoactual = nodoactual.getPadre();
        }
        Nodo[] arraysolucion= new Nodo[solucion.size()];
        solucion.toArray(arraysolucion);
        return arraysolucion;

    }

    @Override
    public String toString() {
        if(padre==null){
            return "Nodo{" +
                    "estado=" + estado +
                    ", accion=" + accion +
                    ", estado padre=null"  +

                    '}';
        }
        return "Nodo{" +
                "estado=" + estado +
                ", accion=" + accion +
                ", estado padre=" + padre.getEstado() +

                '}';
    }
}
