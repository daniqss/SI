package es.udc.sistemasinteligentes.busqueda;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class EstrategiaBusquedaGrafo implements EstrategiaBusqueda {
    public EstrategiaBusquedaGrafo() {}

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception{
        Queue<Nodo> frontera = new ArrayDeque<>();
        ArrayList<Nodo> explorados = new ArrayList<>();
        Accion[] accionesDisponibles;

        Nodo nodoActual = Nodo.creaNodo(p.getEstadoInicial(), null, null);
        frontera.add(Nodo.creaNodo(p.getEstadoInicial(), null, null));

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + nodoActual.getEstado());

        while (!frontera.isEmpty()){
            nodoActual = frontera.poll();
            System.out.println((i++) + " - Explorando " + nodoActual.getEstado());

            if (p.esMeta(nodoActual.getEstado())) {
                System.out.println((i++) + " - FIN - " + nodoActual.getEstado() + " es meta");
                return reconstruyeSolucion(nodoActual);
            }
            explorados.add(nodoActual);

            accionesDisponibles = p.acciones(nodoActual.getEstado());
            for (Accion acc: accionesDisponibles) {
                Nodo sucesor = Nodo.creaNodo(p.result(nodoActual.getEstado(), acc), nodoActual, acc);


                if (!explorados.contains(sucesor) && !frontera.contains(sucesor)) {
                    frontera.add(sucesor);
                    System.out.println((i++) + " - Estado añadido a la frontera: " + sucesor.getEstado());
                }
            }
        }
        throw new Exception("No se ha encontrado solución");
    }

    private Nodo[] reconstruyeSolucion(Nodo solucion) {
        ArrayList<Nodo> solucionReconstruida = new ArrayList<>();
        Nodo nodoActual = solucion.getPadre();

        while (nodoActual != null) {
            solucionReconstruida.add(nodoActual);
            nodoActual = nodoActual.getPadre();
        }
        Collections.reverse(solucionReconstruida);

        return solucionReconstruida.toArray(new Nodo[0]);
    }
}
