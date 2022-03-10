package es.udc.sistemasinteligentes.apartado2c;

import es.udc.sistemasinteligentes.*;

public class MainEj2c {
    public static void main(String[] args) throws Exception {
        int[][] est = {{2, 0, 0}, {0, 0, 0},{0, 0, 0}};
        ProblemaCuadradoOptimizado.EstadoCuadrado estadoInicial = new ProblemaCuadradoOptimizado.EstadoCuadrado(est);//definimos un estado inicial
        ProblemaBusqueda cuadradoMagico = new ProblemaCuadradoOptimizado(estadoInicial);//creamos un nuevo problema busqueda con nuestro estado inicial


        EstrategiaBusqueda buscador = new EstrategiaProfundidad();

        Nodo[] nodos = buscador.soluciona(cuadradoMagico);
        for (Nodo n : nodos) {
            System.out.println(n.toString());
        }
    }
}
