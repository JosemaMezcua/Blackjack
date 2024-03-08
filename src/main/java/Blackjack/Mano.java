package Blackjack;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Indica que la clase Mano será raíz en el XML
public class Mano {

    // XMLWrapper crea un contenedor con las cartas que nos han tocado
    @XmlElementWrapper(name = "cartas")
    @XmlElement(name = "carta")
    private ArrayList<Carta> cartas;

    // constructor que inicia el array
    public Mano() {
        this.cartas = new ArrayList<>();
    }

    // elemento que va al xml, que en este caso es el valor de la mano.
    @XmlElement
    public int getValorMano() {
        return valorMano();
    }

    // Comprueba el valor de la mano y la devuelve
    public int valorMano() {
        int suma = 0;
        for (Carta carta : cartas) {
            suma += carta.getValor();
        }
        return suma;
    }


    // Comprueba si ha acabado el juego y devuelve true o false. Si el usuario se a pasado de 21, el juego acaba
    public boolean finDeJuego() {
        boolean fin = true;
        if (valorMano() > 21) {
            fin = false;
        }
        return fin;
    }

    public String toString() {
        int puntuacion = valorMano();
        StringBuilder result = new StringBuilder("Puntuación de la mano: " + puntuacion + "\n");

        for (Carta carta : cartas) {
            result.append("[ ").append(carta.mostrarNumero()).append(" - ").append(carta.getPaloCarta()).append(" ]\n");
        }

        return result.toString();
    }

    // Metodo que pide una carta al usuario y la añade a la mano. Si no hay cartas en el mazo, devuelve null.
    public Carta pedirCarta(Mazo m) {
        Carta carta = m.solicitarCarta();
        if (carta != null) {
            cartas.add(carta);
        } else {
            System.out.println("No se puede solicitar carta, el mazo está vacío.");
        }
        return carta;
    }
    //Metodo que comprueba si ha hecho blackjack y muestra un mensaje si lo ha hecho.
    public void checkBlackjack() {
        if (valorMano() == 21) {
            System.out.println("¡Felicidades! ¡Has hecho Blackjack!");
        }
    }
}