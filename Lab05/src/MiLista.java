import java.util.Iterator;

public class MiLista implements ListInterface {
    ListNode cabeza;

    // ===================== Operaciones esenciales =====================

    @Override
    public boolean isEmpty() {
        // La lista está vacía cuando no tiene cabeza
        return this.cabeza == null;
    }

    @Override
    public int getSize() {
        // Se recorre la lista desde la cabeza hasta null contando los nodos
        int contador = 0;
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            contador = contador + 1;
            iterador = iterador.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        // Se avanza hasta el último nodo (el que no tiene siguiente)
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Object search(Object object) {
        // Se recorre la lista comparando el dato de cada nodo con el buscado.
        // Si lo encuentra devuelve el nodo, si no devuelve null.
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        // Agregar es lo mismo que insertar al final
        return insertTail(object);
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        // Inserta un nuevo nodo después del nodo dado como referencia
        if (node == null) {
            return false;
        }
        // 1er paso: crear el nuevo nodo
        ListNode nuevo = new ListNode(object);
        // 2do paso: el nuevo nodo apunta al siguiente del nodo de referencia
        nuevo.siguiente = node.siguiente;
        // 3er paso: el nodo de referencia apunta al nuevo nodo
        node.siguiente = nuevo;
        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        // Busca el nodo cuya información es 'ob' e inserta después de él
        ListNode encontrado = (ListNode) search(ob);
        if (encontrado == null) {
            return false; // el nodo de referencia no está en la lista
        }
        return insert(encontrado, object);
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        // Cambia la información guardada en el nodo
        if (node == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        // Caso 1: el nodo a eliminar es la cabeza
        if (this.cabeza == node) {
            this.cabeza = this.cabeza.siguiente;
            return true;
        }
        // Caso 2: se busca el nodo anterior y se conecta con el siguiente del eliminado
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                iterador.siguiente = node.siguiente;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false; // el nodo no estaba en la lista
    }

    // ===================== Operaciones de expansión =====================

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public Object getBeforeTo() {
        return null;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }

    @Override
    public Object getNextTo() {
        return null;
    }

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
