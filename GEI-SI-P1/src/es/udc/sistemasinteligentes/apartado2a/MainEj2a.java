package es.udc.sistemasinteligentes.apartado2a;

import es.udc.sistemasinteligentes.*;

public class MainEj2a {
    public static void main(String[] args) throws Exception {
        int[][] est = {{2, 0, 0}, {0, 0, 0},{0, 0, 0}};
        ProblemaCuadradoMagico.EstadoCuadrado estadoInicial = new ProblemaCuadradoMagico.EstadoCuadrado(est);//definimos un estado inicial
        ProblemaBusqueda cuadradoMagico = new ProblemaCuadradoMagico(estadoInicial);//creamos un nuevo problema busqueda con nuestro estado inicial

        //comenta y descomenta la que quieras usar:
        //EstrategiaBusqueda buscador = new EstrategiaAmplitud();
        EstrategiaBusqueda buscador = new EstrategiaProfundidad();

        Nodo[] nodos = buscador.soluciona(cuadradoMagico);
        for (Nodo n : nodos) {
            System.out.println(n.toString());
        }
    }
}