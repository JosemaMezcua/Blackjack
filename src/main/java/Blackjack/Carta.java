package Blackjack;

import javax.xml.bind.annotation.XmlElement;

public class Carta {
    // Crear los diferentes tipos de Palos de las Cartas con enum
    enum Palo {
        TREBOL, DIAMANTES, CORAZONES, PICAS
    }

    // Variables de tipo String y int
    String paloCarta;
    int numeroCarta;

    // Constructor que dice que el numero tiene que ser menor que 14
    public Carta(int numeroCarta, Palo paloCarta) {
        this.paloCarta = String.valueOf(paloCarta);
        if (numeroCarta > 0 && numeroCarta < 14) {
            this.numeroCarta = numeroCarta;
        } else {
            System.out.println("Error");
        }
    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public String getPaloCarta() {
        return paloCarta;
    }

    // Devuelve el valor de la carta según su número 9, 8 , 10, 12....
    public int getValor() {
        if (numeroCarta == 1) {
            return 11;
        } else if (numeroCarta > 10) {
            return 10;
        } else {
            return numeroCarta;
        }
    }

    // Devuelve el numero y su palo: EJ: si es 13 -> K
    public String mostrarNumero() {
        switch (numeroCarta) {
            case 1:
                return "AS";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                // devuelve el valor del numero en forma de string
                return String.valueOf(numeroCarta);
        }
    }

    // @XMLELEMENT indica que es un valor que se mostrara en el xml final
    @XmlElement
    public String getMostarNumero() {
        return mostrarNumero();
    }
   // Indica el formato de la carta
    @Override
    public String toString() {
        return "[" + mostrarNumero() + " de " + getPaloCarta() + "]";
    }

}


