package Blackjack;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    ArrayList<Carta> cartas = new ArrayList<Carta>();

    // Constructor sin parametros que recorre los palos y añade cada carta en su palo
    public Mazo() {
        for (Carta.Palo p : Carta.Palo.values()) {
            for (int numeroCarta = 1; numeroCarta < 14; numeroCarta++) {
                cartas.add(new Carta(numeroCarta, p));
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    // Baraja el mazo con la libreria collections
    public void barajar() {
        Collections.shuffle(cartas);
    }

    // Solicita una carta al principio del juego y la borra del mazo para que no se vuelva a repetir
    public Carta solicitarCarta() {
        if (!cartas.isEmpty()) {
            Carta cartaSolicitada = cartas.remove(0);
            return cartaSolicitada;
        } else {
            System.out.println("El mazo está vacío.");
            return null;
        }
    }
    // Metodo toString para imprimir el mazo de cartas.
    public String toString() {
        StringBuilder result = new StringBuilder("Mazo de Cartas:\n");

        for (Carta carta : cartas) {
            result.append(carta).append("\n");
        }

        return result.toString();
    }
}
