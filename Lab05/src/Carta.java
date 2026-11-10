// Una carta de póker tiene un palo y un número del 1 al 13.
// Palos: 'C' = Corazones ♥, 'D' = Diamantes ♦, 'P' = Picas ♠, 'T' = Tréboles ♣
public class Carta {
    char palo;
    int numero;

    public Carta(char palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public char getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    // Convierte el número en figura: 1 -> A, 11 -> J, 12 -> Q, 13 -> K
    public String getFigura() {
        if (numero == 1) {
            return "A";
        } else if (numero == 11) {
            return "J";
        } else if (numero == 12) {
            return "Q";
        } else if (numero == 13) {
            return "K";
        } else {
            return "" + numero;
        }
    }

    // Convierte la letra del palo en su símbolo
    public String getSimbolo() {
        if (palo == 'C') {
            return "♥";
        } else if (palo == 'D') {
            return "♦";
        } else if (palo == 'P') {
            return "♠";
        } else {
            return "♣";
        }
    }

    @Override
    public String toString() {
        return getFigura() + getSimbolo();
    }
}
