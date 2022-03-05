package es.udc.sistemasinteligentes.apartado2a;

import es.udc.sistemasinteligentes.*;

public class MainEj1 {
    public static void main(String[] args) throws Exception {
        int[][] est = {{2, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial = new ProblemaCuadradoMagico.EstadoCuadrado(est);//definimos un estado inicial
        ProblemaBusqueda cuadradoMagico = new ProblemaCuadradoMagico(estadoInicial);//creamos un nuevo problemabusqueda con nuestro estado inicial

        EstrategiaBusqueda buscador = new EstrategiaAmplitud();//resolvemos
        Nodo[] nodos = buscador.soluciona(cuadradoMagico);
        for (Nodo n : nodos) {
            System.out.println(n.toString());
        }
    }
}