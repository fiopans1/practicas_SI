package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.ProblemaBusqueda;
import es.udc.sistemasinteligentes.Nodo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);//definimos un estado inicial
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);//creamos un nuevo problemabusqueda con nuestro estado inicial

        //descomenta la estrategia que quieres usar y comenta la otra
        EstrategiaBusqueda buscador = new Estrategia4();//opcion 1
        //EstrategiaBusqueda buscador = new EstrategiaBusquedaGrafo();//opcion 2
        Nodo[] nodos= buscador.soluciona(aspiradora);
        for (Nodo n: nodos) {
            System.out.println(n.toString());
        }
    }
}
