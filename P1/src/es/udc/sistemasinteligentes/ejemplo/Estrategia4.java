package es.udc.sistemasinteligentes.ejemplo;

import es.udc.sistemasinteligentes.busqueda.Accion;
import es.udc.sistemasinteligentes.busqueda.EstrategiaBusqueda;
import es.udc.sistemasinteligentes.busqueda.Nodo;
import es.udc.sistemasinteligentes.busqueda.ProblemaBusqueda;

import java.util.ArrayList;
import java.util.Collections;

public class Estrategia4 implements EstrategiaBusqueda {

    public Estrategia4() {}

    @Override
    public Nodo[] soluciona(ProblemaBusqueda p) throws Exception{
        ArrayList<Nodo> explorados = new ArrayList<Nodo>();
        Nodo nodoActual = Nodo.creaNodo(p.getEstadoInicial(), null, null);
        explorados.add(nodoActual);

        int i = 1;

        System.out.println((i++) + " - Empezando búsqueda en " + nodoActual.getEstado());

        while (!p.esMeta(nodoActual.getEstado())){
            System.out.println((i++) + " - " + nodoActual.getEstado() + " no es meta");
            Accion[] accionesDisponibles = p.acciones(nodoActual.getEstado());
            boolean modificado = false;
            for (Accion acc: accionesDisponibles) {
                Nodo sc = Nodo.creaNodo(p.result(nodoActual.getEstado(), acc), nodoActual, acc);
                System.out.println((i++) + " - RESULT(" + nodoActual.getEstado() + ","+ acc + ")=" + sc);
                if (!explorados.contains(sc)) {
                    nodoActual = sc;
                    System.out.println((i++) + " - " + sc + " NO explorado");
                    explorados.add(nodoActual);
                    modificado = true;
                    System.out.println((i++) + " - Estado actual cambiado a " + nodoActual.getEstado());
                    break;
                }
                else
                    System.out.println((i++) + " - " + sc + " ya explorado");
            }
            if (!modificado) throw new Exception("No se ha podido encontrar una solución");
        }
        System.out.println((i++) + " - FIN - " + nodoActual.getEstado() + " es meta");
        return reconstruyeSolucion(nodoActual);
    }

    private Nodo[] reconstruyeSolucion(Nodo solucion) {
        ArrayList<Nodo> solucionReconstruida = new ArrayList<Nodo>();
        Nodo nodoActual = solucion.getPadre();

        while (nodoActual != null) {
            solucionReconstruida.add(nodoActual);
            nodoActual = nodoActual.getPadre();
        }
        Collections.reverse(solucionReconstruida);

        return solucionReconstruida.toArray(new Nodo[0]);
    }
}