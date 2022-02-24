package es.udc.sistemasinteligentes;

import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

import java.util.ArrayList;

public class Nodo {
    private final Estado estado;
    private final Accion accion;
    private final Nodo padre;
    public Nodo(Estado e, Nodo p, Accion a){
        this.estado=e;
        this.padre=p;
        this.accion=a;


    }
    public ArrayList<Nodo> Sucesores(Estado e, Accion[] accionesDisponibles){
        ArrayList<Nodo> sucesores= new ArrayList<Nodo>();
        for(Accion acc: accionesDisponibles){
            sucesores.add(new Nodo(acc.aplicaA(e),this,acc));
        }
        return sucesores;
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
