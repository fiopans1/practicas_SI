package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.ProblemaBusqueda;

public class Main {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);//definimos un estado inicial
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);//creamos un nuevo problemabusqueda con nuestro estado inicial

        EstrategiaBusqueda buscador = new Estrategia4();//resolvemos
        System.out.println(buscador.soluciona(aspiradora));
    }
}
