import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== 1. Inicialización e impresión =====
        // Palos en el orden pedido: ♥, ♦, ♠, ♣
        char[] palos = {'C', 'D', 'P', 'T'};

        MiLista baraja = new MiLista();
        for (int i = 0; i < palos.length; i++) {
            for (int numero = 1; numero <= 13; numero++) {
                baraja.insertTail(new Carta(palos[i], numero));
            }
        }

        System.out.println("Baraja inicial (" + baraja.getSize() + " cartas):");
        System.out.println(baraja);

        // ===== 2. Menú de interacción =====
        int opcion = 0;
        while (opcion != 3) {
            System.out.println();
            System.out.println("----- MENÚ -----");
            System.out.println("1. Revolver la baraja");
            System.out.println("2. Ordenar por un palo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                // Revolver la baraja con shuffle()
                baraja.shuffle();
                System.out.println("Baraja revuelta:");
                System.out.println(baraja);

            } else if (opcion == 2) {
                // Pedir el palo
                System.out.print("Seleccione un palo (C = ♥, D = ♦, P = ♠, T = ♣): ");
                char palo = scanner.next().toUpperCase().charAt(0);

                if (palo != 'C' && palo != 'D' && palo != 'P' && palo != 'T') {
                    System.out.println("Palo no válido.");
                } else {
                    // Extraer las 13 cartas del palo en una nueva lista
                    MiLista cartasPalo = new MiLista();
                    ListNode iterador = baraja.cabeza;
                    while (iterador != null) {
                        Carta carta = (Carta) iterador.dato;
                        if (carta.getPalo() == palo) {
                            cartasPalo.insertTail(carta);
                        }
                        iterador = iterador.siguiente;
                    }

                    // Ordenarlas con sortList() e imprimir
                    MiLista ordenadas = cartasPalo.sortList();
                    System.out.println("Cartas del palo sin ordenar: " + cartasPalo);
                    System.out.println("Cartas del palo ordenadas:   " + ordenadas);
                }

            } else if (opcion == 3) {
                System.out.println("Fin del programa.");

            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}
