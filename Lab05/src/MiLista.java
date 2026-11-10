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
        return search(object) != null;
    }

    @Override
    public Iterator<ListNode> iterator() {
        // Devuelve un objeto que permite recorrer los nodos uno por uno
        return new MiIterador(this.cabeza);
    }

    @Override
    public Object[] toArray() {
        // Copia los datos de la lista en un arreglo del mismo tamaño
        Object[] arreglo = new Object[getSize()];
        ListNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i = i + 1;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        // Si el arreglo recibido no alcanza, se crea uno nuevo del tamaño de la lista
        if (object == null || object.length < getSize()) {
            object = new Object[getSize()];
        }
        ListNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            object[i] = iterador.dato;
            i = i + 1;
            iterador = iterador.siguiente;
        }
        return object;
    }

    @Override
    public Object getBeforeTo() {
        // Dato que está antes de la cola (el penúltimo)
        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        // Dato del nodo que está antes del nodo recibido
        if (node == null || this.cabeza == null || this.cabeza == node) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public Object getNextTo() {
        // Dato que está después de la cabeza (el segundo)
        return getNextTo(this.cabeza);
    }

    @Override
    public Object getNextTo(ListNode node) {
        // Dato del nodo que está después del nodo recibido
        if (node == null || node.siguiente == null) {
            return null;
        }
        return node.siguiente.dato;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        // Crea una lista nueva copiando los datos desde 'from' hasta 'to' (incluidos)
        MiLista nuevaLista = new MiLista();
        ListNode iterador = from;
        while (iterador != null) {
            nuevaLista.insertTail(iterador.dato);
            if (iterador == to) {
                break;
            }
            iterador = iterador.siguiente;
        }
        return nuevaLista;
    }

    @Override
    public MiLista sortList() {
        // 1er paso: copiar los datos en una lista nueva (la original no cambia)
        MiLista ordenada = subList(this.cabeza, null);
        int n = ordenada.getSize();

        // 2do paso: Bubble Sort sobre los nodos.
        // Bucle externo: se repite n-1 veces.
        for (int i = 0; i < n - 1; i++) {
            ListNode actual = ordenada.cabeza;
            // Bucle interno: compara cada nodo con su siguiente y,
            // si el primero es mayor, intercambia sus datos.
            // En cada vuelta recorre un valor menos.
            for (int j = 0; j < n - 1 - i; j++) {
                if (valorParaOrdenar(actual.dato) > valorParaOrdenar(actual.siguiente.dato)) {
                    Object temporal = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temporal;
                }
                actual = actual.siguiente;
            }
        }
        return ordenada;
    }

    @Override
    public void shuffle() {
        // Para cada posición se escoge otra posición al azar
        // y se intercambian los datos de esos dos nodos.
        int n = getSize();
        ListNode actual = this.cabeza;
        while (actual != null) {
            int posicionAzar = (int) (Math.random() * n);
            ListNode otro = getNode(posicionAzar);

            Object temporal = actual.dato;
            actual.dato = otro.dato;
            otro.dato = temporal;

            actual = actual.siguiente;
        }
    }

    // ===================== Métodos auxiliares =====================

    // Devuelve el nodo que está en la posición indicada (la cabeza es la posición 0)
    public ListNode getNode(int posicion) {
        ListNode iterador = this.cabeza;
        int contador = 0;
        while (iterador != null && contador < posicion) {
            iterador = iterador.siguiente;
            contador = contador + 1;
        }
        return iterador;
    }

    // Número que se usa para comparar al ordenar:
    // si es una carta se usa su número (1 a 13), si es un entero se usa el mismo entero.
    private int valorParaOrdenar(Object dato) {
        if (dato instanceof Carta) {
            Carta carta = (Carta) dato;
            return carta.getNumero();
        }
        if (dato instanceof Integer) {
            return (Integer) dato;
        }
        return 0;
    }

    @Override
    public String toString() {
        // Recorre la lista y arma un texto como: [A♥, 2♥, 3♥]
        String texto = "[";
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            texto = texto + iterador.dato;
            if (iterador.siguiente != null) {
                texto = texto + ", ";
            }
            iterador = iterador.siguiente;
        }
        texto = texto + "]";
        return texto;
    }
}
