package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.busqueda.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.busqueda.ProblemaBusqueda;

public class Main {

    public static void main(String[] args) throws Exception {
        ProblemaAspiradora.EstadoAspiradora estadoInicial = new ProblemaAspiradora.EstadoAspiradora(ProblemaAspiradora.EstadoAspiradora.PosicionRobot.IZQ,
                                                                                                    ProblemaAspiradora.EstadoAspiradora.PosicionBasura.AMBAS);
        ProblemaBusqueda aspiradora = new ProblemaAspiradora(estadoInicial);

        EstrategiaBusqueda buscador = new Estrategia4();
        System.out.println(buscador.soluciona(aspiradora));
    }
}
