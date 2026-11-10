# Práctica 05 – Baraja de Póker con Lista Enlazada Propia

Programa en Java que crea y administra una baraja de póker de 52 cartas usando
únicamente una lista simplemente enlazada propia (`MiLista`), sin colecciones de Java.

## Archivos (`src/`)

| Archivo | Descripción |
|---|---|
| `ListNode.java` | Nodo de la lista (dato + referencia al siguiente). |
| `ListInterface.java` | Interfaz de la lista, con `shuffle()` agregado. |
| `MiIterador.java` | Recorre los nodos uno por uno (lo pide `iterator()`). |
| `MiLista.java` | Implementación completa de la lista enlazada. |
| `Carta.java` | Carta de póker (palo + número). |
| `Main.java` | Crea la baraja y muestra el menú interactivo. |

## Funcionamiento

1. Al iniciar imprime la baraja ordenada por palos (♥, ♦, ♠, ♣) y números 1–13,
   mostrando 1 → A, 11 → J, 12 → Q, 13 → K.
2. Menú:
   1. **Revolver la baraja** – `shuffle()`: cada nodo intercambia su dato con el de una posición al azar.
   2. **Ordenar por un palo** – se elige `C` (♥), `D` (♦), `P` (♠) o `T` (♣); sus 13 cartas
      se copian en una nueva `MiLista` y se ordenan con `sortList()` (Bubble Sort sobre los nodos).
   3. **Salir**.

## Ejecución

Abrir la carpeta en IntelliJ IDEA y ejecutar `Main`.
