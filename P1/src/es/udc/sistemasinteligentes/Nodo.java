package es.udc.sistemasinteligentes;

public class Nodo {
    final private Estado estado;
    final private Nodo padre;
    final private Accion accion;

    private Nodo(Estado estado, Nodo padre, Accion accion) {
        this.estado = estado;
        this.padre = padre;
        this.accion = accion;
    }

    public static Nodo creaNodo(Estado estado, Nodo padre, Accion accion) {
        return new Nodo(estado, padre, accion);
    }

    public Estado getEstado() {
        return estado;
    }

    public Nodo getPadre() {
        return padre;
    }
}
