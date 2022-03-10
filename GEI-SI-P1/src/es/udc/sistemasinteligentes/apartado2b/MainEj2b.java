package es.udc.sistemasinteligentes.apartado2b;

import es.udc.sistemasinteligentes.*;
import es.udc.sistemasinteligentes.apartado2a.*;

public class MainEj2b {
    public static void main(String[] args) throws Exception {
        int[][] est = {{2, 0, 0}, {0, 0, 0},{0, 0, 0}};
        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial = new ProblemaCuadradoMagico.EstadoCuadrado(est);//definimos un estado inicial
        ProblemaBusqueda cuadradoMagico = new ProblemaCuadradoMagico(estadoInicial);//creamos un nuevo problema busqueda con nuestro estado inicial

        EstrategiaBusquedaInformada buscador = new BusquedaA();
        Heuristica h=new HeuristicaCuadradoMagico();
        Nodo[] nodos = buscador.soluciona(cuadradoMagico,h);
        for (Nodo n : nodos) {
            System.out.println(n.toString());
        }
    }
}
