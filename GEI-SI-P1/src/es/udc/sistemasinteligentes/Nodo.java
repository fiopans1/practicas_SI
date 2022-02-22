package es.udc.sistemasinteligentes;

import es.udc.sistemasinteligentes.ejemplo.ProblemaAspiradora;

import java.util.ArrayList;

public class Nodo {
    private Estado estado;
    private Accion accion;
    private Nodo padre;
    public Nodo(Estado e, Nodo p, Accion a){
        this.estado=e;
        this.padre=p;
        this.accion=a;


    }

    public static Nodo CrearNodo(Estado e, Nodo p, Accion a){
        return new Nodo(e,p,a);

    }
    public ArrayList<Nodo> Sucesores(Estado e, Accion[] accionesDisponibles){
        ArrayList<Nodo> sucesores= new ArrayList<Nodo>();
        for(Accion acc: accionesDisponibles){
            sucesores.add(new Nodo(acc.aplicaA(e),this,acc));
        }
        return sucesores;
    }
}
