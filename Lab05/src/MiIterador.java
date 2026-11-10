import java.util.Iterator;

// Permite recorrer los nodos de MiLista uno por uno, empezando por la cabeza.
// Se necesita porque la interfaz pide el método iterator().
public class MiIterador implements Iterator<ListNode> {
    ListNode actual;

    public MiIterador(ListNode cabeza) {
        this.actual = cabeza;
    }

    @Override
    public boolean hasNext() {
        // Hay siguiente mientras no se haya llegado a null
        return this.actual != null;
    }

    @Override
    public ListNode next() {
        // Devuelve el nodo actual y avanza al siguiente
        ListNode nodo = this.actual;
        this.actual = this.actual.siguiente;
        return nodo;
    }
}
